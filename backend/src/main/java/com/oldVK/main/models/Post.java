package com.oldVK.main.models;

public class Post {
    public Post(){}
    public Post(String owner_name,
                       String author_name,
                       String message) {
        this.owner_name = owner_name;
        this.author_name = author_name;
        this.message = message;
    }

    private int id;
    private int owner_id;
    private int author_id;
    private String author_name;
    private String owner_name;
    private String message;
}
