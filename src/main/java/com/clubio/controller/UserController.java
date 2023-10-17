package com.clubio.controller;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.clubio.entity.R;
import com.clubio.entity.User;
import com.clubio.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Tag(name = "用户管理模块")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "根据id查询用户信息")
    @GetMapping("/select/{id}")
    public SaResult selectUserById(@Schema(description = "用户id") @PathVariable Long id){
        if (ObjectUtil.isNull(id)) {
            return SaResult.error("用户id有误");
        }
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUserId, id);
        User user = userService.getOne(userLambdaQueryWrapper);
        if (ObjectUtil.isNull(user)) {
            return SaResult.error("数据库不存在这个用户---->id="+id);
        }
        return SaResult.data(user);


    }

    @PostMapping
    public SaResult addUser(@RequestBody User user){
        
        return null;
    }
}
