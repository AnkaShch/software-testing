package com.oldVK.main.dao;

import com.oldVK.main.models.Post;

import java.util.List;

public interface PostDao {
    public List<Post> getPosts(int owner_id);
}
