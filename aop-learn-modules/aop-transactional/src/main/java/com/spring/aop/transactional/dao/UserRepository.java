package com.spring.aop.transactional.dao;

import com.spring.aop.transactional.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author calebman
 * @date 2018/8/16
 * @description 用户信息的数据库操作接口
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
