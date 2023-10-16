package com.clubio.config;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.clubio.entity.Role;
import com.clubio.entity.User;
import com.clubio.entity.UserRole;
import com.clubio.service.RoleService;
import com.clubio.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Smile
 * @date 2023-10-16 14:23
 * 自定义权限加载接口实现类
 */


// 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    /**
     * 返回一个账号所拥有的权限码集合(未使用)
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 本 list 仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        list.add("101");
        list.add("user.add");
        list.add("user.update");
        list.add("user.get");
        // list.add("user.delete");
        list.add("art.*");
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        log.info("loginid---->{}---logintype----->{}",loginId,loginType);
        LambdaQueryWrapper<UserRole> userRoleQueryWrapper = new LambdaQueryWrapper<UserRole>()
                .eq(UserRole::getUserId, loginId);
        List<UserRole> userRoleList = userRoleService.list(userRoleQueryWrapper);
        //权限集合
        List<String> roleList = new ArrayList<String>();
        if (ObjectUtil.isNotNull(userRoleList)) {
            userRoleList.forEach(userRole -> {
                LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<Role>()
                        .eq(Role::getRoleId, userRole.getRoleId());
                Role role = roleService.getOne(roleLambdaQueryWrapper);
                roleList.add(role.getRoleName());
            });
        }
        //去重复后返回
        return roleList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

}
