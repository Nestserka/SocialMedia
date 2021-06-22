package socialnet.com.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Entity(name = "following")
@Table(name = "following")
public class Following {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User following;


    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following=following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Following)) return false;
        Following following1=(Following) o;
        return id.equals(following1.id) && following.equals(following1.following);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, following);
    }



}
