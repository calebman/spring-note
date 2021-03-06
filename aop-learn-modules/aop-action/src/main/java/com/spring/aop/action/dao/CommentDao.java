package com.spring.aop.action.dao;

import com.spring.aop.action.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author calebman
 * @date 2018/8/18
 * @description
 */
public interface CommentDao extends JpaRepository<Comment, Long> {
}
