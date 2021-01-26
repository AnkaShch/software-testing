package com.oldVK.main.dao;

import com.oldVK.main.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserJdbcDao extends JdbcDaoSupport implements UserDao {
    public UserJdbcDao(DataSource dataSource) {
        super();
        setDataSource(dataSource);
        String initSqlUsers = "CREATE TABLE IF NOT EXISTS USER " +
                "(ID INTEGER primary key AUTOINCREMENT not null," +
                "NAME TEXT not null, " +
                "PASSWORD TEXT not null);";
        getJdbcTemplate().update(initSqlUsers);
    }

    @Override
    public int addUser(String login, String password) {
        String sql = "INSERT INTO USER (NAME, PASSWORD) VALUES (" +
                "'" + login + "'" +
                ", " +
                "'" + password + "'" +
                ");";
        System.out.println(login + password);
        return getJdbcTemplate().update(sql);
    }

    @Override
    public int getUser(String login, String password) {
        String sql = "SELECT * FROM USER " +
                "WHERE NAME = \"" +
                login + "\"" +
                " AND PASSWORD = \"" +
                password +
                "\";";
        List<User> users = getUsersBySql(sql);
        if (users.size() == 0) {
            return 0;
        } else {
            return users.get(0).getId();
        }
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM USER";
        List<User> users = getUsersBySql(sql);
        return users;
    }

    private List<User> getUsersBySql(String sql) {
//        System.out.println("!!!!SQL: " + sql);
        List<User> users = new ArrayList<User>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            User user = new User((int)row.get("id"), (String)row.get("name"), (String)row.get("password"));
//            user.print();
            users.add(user);
        }
        return users;
    }
}
