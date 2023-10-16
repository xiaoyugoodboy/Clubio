package com.clubio.controller;

import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Smile
 * @date 2023-10-16 14:01
 */
@RestController
@RequestMapping("/test")
public class SmileTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/info")
    public SaResult test1() {
        stringRedisTemplate.opsForValue().set("xiaoyu","smile");
        String s = stringRedisTemplate.opsForValue().get("xiaoyu");
        System.out.println(s);
        return SaResult.data("访问成功");
    }

}
