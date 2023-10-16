package com.clubio.entity;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Smile
 * @date 2023-10-16 18:44
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    public R() {
        put("error_code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(405, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(405, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("error_code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }
    //自己重载的方法
    public static R ok(int error_code, String msg) {
        R r = new R();
        r.put("msg", msg);
        r.put("error_code",error_code);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}