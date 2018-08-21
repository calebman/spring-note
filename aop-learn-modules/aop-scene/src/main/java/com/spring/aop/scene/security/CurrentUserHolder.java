package com.spring.aop.scene.security;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 当前用户存储工具 取当前线程的存储对象
 */
public class CurrentUserHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String get() {
        return holder.get() == null ? "unknown" : holder.get();
    }

    public static void set(String username) {
        holder.set(username);
    }
}
