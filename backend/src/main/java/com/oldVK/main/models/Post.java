package com.oldVK.main.models;

public class Post {
    public Post(String author_name, String message){
        this.author_name = author_name;
        this.message = message;
    }

    private int owner_id;
    private int author_id;
    private String author_name;
    private String message;
}
