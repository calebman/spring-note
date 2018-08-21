package com.spring.aop.transactional.dao;

import com.spring.aop.transactional.pojo.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author calebman
 * @date 2018/8/16
 * @description 操作记录的数据库操作接口
 */
public interface OperationLogRepository extends JpaRepository<OperationLog, Long> {
}
