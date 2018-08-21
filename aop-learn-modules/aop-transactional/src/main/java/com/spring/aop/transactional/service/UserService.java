package com.spring.aop.transactional.service;

import com.spring.aop.transactional.dao.OperationLogRepository;
import com.spring.aop.transactional.dao.UserRepository;
import com.spring.aop.transactional.pojo.OperationLog;
import com.spring.aop.transactional.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author calebman
 * @date 2018/8/16
 * @description 使用事务框架的服务类
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OperationLogRepository operationLogRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
        OperationLog operationLog = new OperationLog();
        operationLog.setUsername("admin");
        operationLog.setCreateDate(new Date());
        operationLog.setLogText("add user info " + user.toString());
        operationLogRepository.save(operationLog);
    }

    @Transactional
    public void clearUserAndLog() {
        userRepository.deleteAll();
        operationLogRepository.deleteAll();
    }
}
