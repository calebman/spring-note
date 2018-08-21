package com.spring.aop.action.security;

import com.spring.aop.action.pojo.User;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 当前用户存储工具 取当前线程的存储对象
 */
public class CurrentUserHolder {
    private static final ThreadLocal<CurrentUser> holder = new ThreadLocal<>();

    public static CurrentUser getCurrentUser() {
        return holder.get();
    }

    public static void generatorUser(User user) {
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(user);
        currentUser.setRoles(new String[]{user.getPermission()});
        holder.set(currentUser);
    }

    public static void generatorAdmin() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setState(1);
        user.setPermission(Permission.ADMIN.toString());
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(user);
        currentUser.setRoles(new String[]{user.getPermission()});
        holder.set(currentUser);
    }
}
