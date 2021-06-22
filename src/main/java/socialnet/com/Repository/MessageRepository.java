package socialnet.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.entity.User;
import socialnet.com.entity.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findByUserFrom(User user);
    List<Message> findByUserTo(User user);

}