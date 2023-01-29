package com.company.chatterbook.models;

import java.util.List;

// user model
public class User {
    // properties
    private String name;
    private List<ChatterPost> chatterPosts;

    // constructor
    public User(String name) {
        this.name = name;
    }

    // get name
    public String getName() {
        return name;
    }

    // set name
    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    // get chatter posts
    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

}
