package com.spring.aop.action.dao;

import com.spring.aop.action.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 用户信息数据库操作接口
 */
public interface UserDao extends JpaRepository<User, Long> {

    @Query("select t from #{#entityName} t where t.username = ?1 and t.password = ?2")
    User findUserByUsernameAndPassword(String username, String password);
}
