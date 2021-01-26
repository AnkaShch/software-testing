package com.oldVK.main.utils;

import com.oldVK.main.dao.PostDao;
import com.oldVK.main.dao.PostJdbcDao;
import com.oldVK.main.dao.UserDao;
import com.oldVK.main.dao.UserJdbcDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
public class JdbcDaoContextConfiguration {
    @Bean
    public UserDao userDao(DataSource dS) { return new UserJdbcDao(dS); }

//    @Bean
//    public PostDao postDao(DataSource dS) {return new PostJdbcDao(dS); }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:db.sqlite");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }
}
