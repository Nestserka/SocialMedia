package socialnet.com.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

// нужен ли хэшкод на юзера (учитывает все поля)
//он мне сказал добавить сюда айди
@Entity(name = "messages")
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Long
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
    @Column
    private String context;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User userTo;
    @ManyToOne
    @JoinColumn (referencedColumnName = "id")
    private User userFrom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) && createdDate.equals(message.createdDate) && context.equals(message.context) && userTo.equals(message.userTo) && userFrom.equals(message.userFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, context, userTo, userFrom);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }


    public Message(){

    }




}
