package models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class User {
    private String name;
    private String phone;
    private String faculty;
    private String gender;
    private Role userRole;

    public User(){

    }

    public User(String name, String phone, String faculty, String gender, Role userRole) {
        this.name = name;
        this.phone = phone;
        this.faculty = faculty;
        this.gender = gender;
        this.userRole = userRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGender() {
        return gender;
    }

    public Role getUserRole() {
        return userRole;
    }
}
