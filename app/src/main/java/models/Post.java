package models;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Post {
    private String title;
    private String content;
    private String imageUrl;
    private Form form;

    public Post() {
    }

    public Post(String title, String content, String imageUrl, Form form) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.form = form;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Form getForm() {
        return form;
    }
}
