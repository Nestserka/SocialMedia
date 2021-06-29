package socialnet.com.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity(name = "comments")
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Long
    @Column
    private String text;
    @Column( columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
    @ManyToOne(optional = true, targetEntity = Post.class)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post; //post id DTO

    {}

    public Comment(long id, String text, Date createdDate,  Post post) {
        this.id=id;
        this.text=text;
        this.createdDate=createdDate;
        this.post=post;
    }

    public Comment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text=text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate=createdDate;
    }


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post=post;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment that=(Comment) o;
        return id == that.id && text.equals(that.text) && createdDate.equals(that.createdDate)  && post.equals(that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, createdDate, post);
    }


}
