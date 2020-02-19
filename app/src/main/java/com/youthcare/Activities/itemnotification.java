package com.youthcare.Activities;

public class itemnotification {
    private String title,text,time;
    private int img;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public int getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public itemnotification(String title, String text, String time, int img) {
        this.title = title;
        this.text = text;
        this.time = time;
        this.img = img;
    }

    public itemnotification() {
    }
}
