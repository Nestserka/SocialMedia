package socialnet.com.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

@Entity(name = "post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Long
    @Column
    private String context;
    @Column
    private int likes;
    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "user1",referencedColumnName = "id")
    private User user;
     //base64 -- формат в каком картинку нужно передавать уже в самом ответе. а здесь нужно указать только путь. нужно генерировать уникальное имя uuid . пользовать в пост методе загрузил картинку

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post= (Post) o;
        return likes == post.likes && id.equals(post.id) &&  context.equals(post.context) && createdDate.equals(post.createdDate) && user.equals(post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, context, likes, createdDate, user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
