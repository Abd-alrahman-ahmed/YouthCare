package models;

import java.util.List;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class department {
    private String name;
    private String about;
    private User headUser;
    private List<Post> posts;

    public department() {}

    public department(String name, String about, User headUser, List<Post> departmentPosts) {
        this.name = name;
        this.about = about;
        this.headUser = headUser;
        this.posts = departmentPosts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setHeadUser(User headUser) {
        this.headUser = headUser;
    }

    public void setPosts(List<Post> departmentPosts) {
        this.posts = departmentPosts;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public User getHeadUser() {
        return headUser;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
