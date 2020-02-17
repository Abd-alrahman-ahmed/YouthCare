package models;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Notification {
    private String content;
    private String date;
    private String departmentId;

    public Notification() {
    }

    public Notification(String content, String date, String departmentId) {
        this.content = content;
        this.date = date;
        this.departmentId = departmentId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getDepartmentId() {
        return departmentId;
    }
}
