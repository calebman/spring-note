package com.spring.aop.transactional.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @author calebman
 * @date 2018/8/16
 * @description 操作记录实体
 */
@Entity
@Table(name = "operation_log")
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "log_text")
    private String logText;

    @Column(name = "create_date")
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogText() {
        return logText;
    }

    public void setLogText(String logText) {
        this.logText = logText;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "OperationLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", logText='" + logText + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
