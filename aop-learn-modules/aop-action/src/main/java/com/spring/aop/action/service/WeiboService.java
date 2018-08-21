package com.spring.aop.action.service;

import com.spring.aop.action.annotation.RequirePermission;
import com.spring.aop.action.dao.CommentDao;
import com.spring.aop.action.dao.WeiboDao;
import com.spring.aop.action.pojo.Comment;
import com.spring.aop.action.pojo.Weibo;
import com.spring.aop.action.security.CurrentUserHolder;
import com.spring.aop.action.security.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 微博服务类
 */
@Service
@Slf4j
@RequirePermission({Permission.ADMIN, Permission.NORMAL})
public class WeiboService {

    @Autowired
    private WeiboDao weiboDao;

    @Autowired
    private CommentDao commentDao;

    /**
     * 创建一条微博
     *
     * @param title   微博标题
     * @param content 微博内容
     */
    public void createWeibo(String title, String content) {
        Weibo weibo = new Weibo();
        weibo.setTitle(title);
        weibo.setContent(content);
        weibo.setCreateDate(new Date());
        weibo.setUser(CurrentUserHolder.getCurrentUser().getUser());
        weiboDao.save(weibo);
    }

    /**
     * 指定微博创建一条评论
     *
     * @param content 评论内容
     */
    public void createComment(Weibo weibo, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreateDate(new Date());
        comment.setWeibo(weibo);
        commentDao.save(comment);
    }

    /**
     * 获取所有微博
     *
     * @return 所有微博列表
     */
    public List<Weibo> getWeiboList() {
        return weiboDao.findAll();
    }
}
