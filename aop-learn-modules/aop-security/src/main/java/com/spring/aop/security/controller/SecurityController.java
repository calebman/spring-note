package com.spring.aop.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author calebman
 * @date 2018/8/17
 * @description 安全框架测试
 */
@Controller
public class SecurityController {

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    @ResponseBody
    public String homeAccess() {
        return "only login can success";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "only admin can success";
    }
}
