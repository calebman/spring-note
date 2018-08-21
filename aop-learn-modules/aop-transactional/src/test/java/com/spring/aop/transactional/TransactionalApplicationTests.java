package com.spring.aop.transactional;

import com.spring.aop.transactional.pojo.User;
import com.spring.aop.transactional.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionDefinition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalApplicationTests {

    @Autowired
    UserService userService;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUsername("calebman");
        user.setPassword("123456");
        user.setState(1);
        userService.addUser(user);
    }

    @Test
    public void clearUserAndLogTest() {
        userService.clearUserAndLog();
    }

    // 业务代码都要嵌套在try catch模板代码中
    // 接触了底层Connection的事务功能，当使用其他一些框架时，我们更多的不会直接与Connection打交道，如使用Hibernate时，就不容易获取Connection。
    @Test
    public void connTest() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            // 录入用户
            PreparedStatement ps = con.prepareStatement("insert into user(username,password,state) value('calebman','123456',1)");
            ps.execute();
            // 录入日志
            ps = con.prepareStatement("insert into operation_log(username,log_text) value('admin','add user info XXX')");
            ps.execute();
            // 提交
            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
