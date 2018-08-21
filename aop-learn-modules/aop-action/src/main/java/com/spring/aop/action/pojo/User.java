package com.spring.aop.action.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 用户实体
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "realname", length = 100)
    private String realname;

    @Column(name = "state")
    private Integer state;

    @Column(name = "permission")
    private String permission;
}
