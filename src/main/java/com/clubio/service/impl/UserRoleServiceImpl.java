package com.clubio.service.impl;

import com.clubio.entity.UserRole;
import com.clubio.mapper.UserRoleMapper;
import com.clubio.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
