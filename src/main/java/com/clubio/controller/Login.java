package com.clubio.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.clubio.entity.User;
import com.clubio.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Smile
 * @date 2023-10-15 15:15
 */
@Tag(name="登录模块")
@Slf4j
@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    private UserService userService;

    @Operation(summary = "登录接口")
    @GetMapping("/doLogin/{name}/{password}")
    public SaResult doLogin(@PathVariable @Schema(description = "账号")  String name, @PathVariable @Schema(description = "密码") String password) {
        log.info("账号-->{},密码--->{}",name,password);
        if (StrUtil.hasBlank(name)||StrUtil.hasBlank(password)) {
            return SaResult.error("账号或者密码为空");
        }
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUserName, name)
                .eq(User::getPassword, password);
        User user = userService.getOne(userLambdaQueryWrapper);
        log.info("user-->",user);
        //是否有结果
        if (ObjectUtil.isNull(user)) {
            return SaResult.error("登录失败，用户不存在");
        }else {
            //用户登录
            StpUtil.login(user.getUserId());
            //获取用户登录的token
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
    }
    @Operation(summary = "查询是否登录")
    @GetMapping("/isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    @Operation(summary = "查询token信息")
    @GetMapping("/tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    @Operation(summary = "注销")
    @GetMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

}
