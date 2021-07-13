package socialnet.com.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;


import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;

//entity


@Entity (name = "user1")
@Table (name = "user1")
public class User {

    @Id
    @SequenceGenerator(
            name="user1_sequence",
            sequenceName="user1_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=SEQUENCE,
            generator="user1_sequence"
    )
    @Column(
            updatable=false
    )
    private Long id;
    @Column(
            nullable=false,
            columnDefinition="varchar")
    private String firstName;
    @Column(
            nullable=false,
            columnDefinition="varchar") //varchar
    private String lastName;
    @Column
    private String password;
    @Column
    private long subscribers; //qty
    @OneToMany
    private List<Following> following; //null
    @Column
    private String email;
    @OneToMany(mappedBy="userTo",
            cascade = CascadeType.ALL,orphanRemoval=true
    )
    private Set<Message> messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public long getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(long subscribers) {
        this.subscribers=subscribers;
    }

    public List<Following> getFollowing() {
        return following;
    }

    public void setFollowing(List<Following> following) {
        this.following=following;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages=messages;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user=(User) o;
        return subscribers == user.subscribers && id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && password.equals(user.password) && following.equals(user.following) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, password, subscribers, following, email);
    }
}

