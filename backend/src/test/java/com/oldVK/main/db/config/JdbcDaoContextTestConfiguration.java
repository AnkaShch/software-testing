package com.oldVK.main.db.config;

import com.oldVK.main.dao.PostDao;
import com.oldVK.main.dao.PostJdbcDao;
import com.oldVK.main.dao.UserDao;
import com.oldVK.main.dao.UserJdbcDao;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@TestConfiguration
public class JdbcDaoContextTestConfiguration {

    @Bean
    public UserDao userDao(DataSource dS) {
        return new UserJdbcDao(dS);
    }

    @Bean
    public PostDao postDao(DataSource dS) {
        return new PostJdbcDao(dS);
    }

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
