package com.oldVK.main.dao;

import com.oldVK.main.models.User;

import java.util.List;

public interface UserDao {
    int addUser(String login, String password);
    int getUser(String login, String password);
    List<User> getUsers();
}
