package common.server.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "COMMENT_TABLE")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String content;

    @JsonBackReference
    @ManyToOne
    private Post post;

    @OneToOne
    private User user;

    private Date date;

    public Comment() {
    }

    public Comment(String content, Post post, User user, Date date) {
        this.content = content;
        this.post = post;
        this.user = user;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(content, comment.content) &&
                Objects.equals(post, comment.post) &&
                Objects.equals(user, comment.user) &&
                Objects.equals(date, comment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, post, user, date);
    }
}
