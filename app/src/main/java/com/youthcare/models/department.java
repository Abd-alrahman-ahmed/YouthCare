package com.youthcare.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class department {
    private String name;
    private String about;
    private int image;
    private User headUser;
    private List<Post> posts;

    public department() {
    }

    public department(String name, String about, int image, User headUser, List<Post> departmentPosts) {
        this.name = name;
        this.about = about;
        this.image = image;
        this.headUser = headUser;
        this.posts = departmentPosts;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public User getHeadUser() {
        return headUser;
    }

    public void setHeadUser(User headUser) {
        this.headUser = headUser;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> departmentPosts) {
        this.posts = departmentPosts;
    }
}
