package socialnet.com.entity;

import javax.persistence.*;
import java.sql.Date;
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
        Message that = (Message) o;
        return id == that.id && createdDate.equals(that.createdDate) && context.equals(that.context) && userTo.equals(that.userTo) && userFrom.equals(that.userFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, context, userTo, userFrom);
    }

    public Message(long id, Date createdDate, String context, User userTo, User userfrom) {
        this.id = id;
        this.createdDate = createdDate;
        this.context = context;
        this.userTo = userTo;
        this.userFrom = userfrom;
    }


    public Message(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public User getUserfrom() {
        return userFrom;
    }

    public void setUserfrom(User userfrom) {
        this.userFrom = userfrom;
    }

    //two lines with user каждое сообщение должно хранить двух пользователь




}
