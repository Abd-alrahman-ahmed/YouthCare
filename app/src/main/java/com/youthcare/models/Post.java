package com.youthcare.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Post {
    private String title;
    private String content;
    private int postImage;
    private int userImage;
    private Form form;
    private String date;

    public Post() {
    }

    public Post(String title, String content, int userImage, Form form, String date) {
        this.title = title;
        this.content = content;
        this.userImage = userImage;
        this.form = form;
        this.date = date;
        this.postImage = userImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public int getPostImage() {
        return postImage;
    }
}
