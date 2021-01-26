package com.oldVK.main.db;

import com.oldVK.main.models.User;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class DBTest {
    public DBTest() throws SQLException {
    }

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
//    private UserDao userDao = new UserJdbcDao(dataSource());
    private DataSource db = dataSource();

    @Test
    public void testAddUser() throws SQLException {
        assertNotNull("User DAO is null.",db);
        String testerLogin = "Tester";
        String testerName = "123123";
        User tester = new User(testerLogin, testerName);
//        tester.addUser(db);

//        List<User> result = userDao.getUser("tester");
//
//        assertEquals(1, result.size());
//        assertEquals("Tester", result.get(0).getName());
    }
}
