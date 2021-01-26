package com.oldVK.main.db;

import com.oldVK.main.dao.PostDao;
import com.oldVK.main.dao.PostJdbcDao;
import com.oldVK.main.dao.UserDao;
import com.oldVK.main.dao.UserJdbcDao;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
public class DBTest {

    public DataSource dataSource() {
        MySQLContainer<?> mysql = new MySQLContainer<>("mysql:5.6.42");
        mysql.start();
        System.out.println(mysql.getJdbcUrl());
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(mysql.getDriverClassName());
        hikariConfig.setJdbcUrl(mysql.getJdbcUrl());
        hikariConfig.setUsername(mysql.getUsername());
        hikariConfig.setPassword(mysql.getPassword());

        return new HikariDataSource(hikariConfig);
    }

    private UserDao userDao = new UserJdbcDao(dataSource());
    private PostDao postDao = new PostJdbcDao(dataSource());

    @Test
    public void testAddUser() {
        String login = "tester";
        String password = "123456";
        userDao.addUser(login, password);
        int userId = userDao.getUser(login, password);
        assertEquals(1, userId);
    }
}