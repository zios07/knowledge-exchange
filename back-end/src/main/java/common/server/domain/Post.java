package common.server.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "POST_TABLE")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String content;

    private Date date;

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @ManyToOne
    private User user;

    private String category;

    public Post() {
    }

    public Post(String title, String content, Date date, List<Comment> comments, User user, String category) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.comments = comments;
        this.user = user;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(date, post.date) &&
                Objects.equals(comments, post.comments) &&
                Objects.equals(user, post.user) &&
                Objects.equals(category, post.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, date, comments, user, category);
    }
}
