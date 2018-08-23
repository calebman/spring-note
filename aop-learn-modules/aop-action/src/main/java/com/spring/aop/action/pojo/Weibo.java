package com.spring.aop.action.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 微博实体
 */
@Getter
@Setter
@Entity
@Table(name = "weibo")
public class Weibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "weibo", fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<Comment>();

    @Override
    public String toString() {
        return "Weibo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
