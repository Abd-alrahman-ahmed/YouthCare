package com.youthcare.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Role {
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
