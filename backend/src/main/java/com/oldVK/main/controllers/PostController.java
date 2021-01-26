package com.oldVK.main.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oldVK.main.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {
    private final PostDao postDao;

    private final ObjectMapper mapper = new ObjectMapper();


    @Autowired
    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }
    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    @RequestMapping(value = "/api/GetPosts")
    @ResponseBody
    public String getPosts(@RequestParam("user_id") int user_id) throws JsonProcessingException {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(postDao.getPosts(user_id));
    }
}
