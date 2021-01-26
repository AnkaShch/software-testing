package com.oldVK.main.db.config;

import com.oldVK.main.models.User;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@TestConfiguration
public class JdbcDaoContextTestConfiguration {
//    @Bean
//    public User userDao(DataSource dS) {
////        return new User();
//    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:test.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }
}