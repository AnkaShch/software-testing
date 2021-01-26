package com.oldVK.main.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.oldVK.main.dao.UserDao;
import com.oldVK.main.models.User;
import com.oldVK.main.utils.cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class UserController {
    private final UserDao userDao;

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/api/login")
    @ResponseBody
    public String getUser(HttpServletResponse response, HttpServletRequest request) throws IOException, SQLException {
        if (request.getMethod().equals("POST")) {
            if (cookie.Get(request, "user_id").isEmpty()) {

                Gson json = new Gson();
                User user = json.fromJson(request.getReader(), User.class);

                if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
                    throw new IOException("user_name or user_password is null");
                }

                int user_id = userDao.getUser(user.getName(), user.getPassword());
//                System.out.println(user_id);
                return mapper.writeValueAsString(user_id);

            } else {
                response.sendRedirect("http://localhost:8081/");
                return null;
            }
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/api/registration")
    @ResponseBody
    public String addUser(HttpServletResponse response, HttpServletRequest request) throws IOException {
        if (request.getMethod().equals("POST")) {

            if (cookie.Get(request, "user_id").isEmpty()) {
                try {
                    Gson json = new Gson();
                    User user = json.fromJson(request.getReader(), User.class);

                    if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
                        throw new IOException("user_name or user_password is null");
                    }

                    userDao.addUser(user.getName(), user.getPassword());
                    return mapper.writeValueAsString(userDao.getUser(user.getName(), user.getPassword()));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                response.sendRedirect("http://localhost:8081/");
            }
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/api/getListOfUsers")
    @ResponseBody
    public String getUsers() throws JsonProcessingException {
        return mapper.writeValueAsString(userDao.getUsers());
    }
}