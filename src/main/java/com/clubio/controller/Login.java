package com.clubio.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.clubio.entity.User;
import com.clubio.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Smile
 * @date 2023-10-15 15:15
 */
@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    private UserMapper userMapper;
    // 会话登录接口
    @GetMapping("/doLogin")
    public SaResult doLogin(String name, String pwd) {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        // 第一步：比对前端提交的账号名称、密码
        if("zhang".equals(name) && "123456".equals(pwd)) {
            // 第二步：根据账号id，进行登录
            StpUtil.login("zhang");
            // 第2步，获取 Token  相关参数
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
        return SaResult.error("登录失败");
    }
    // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    @GetMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @PostMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/acc/logout
    @GetMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

}
