package socialnet.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.entity.Comment;
import socialnet.com.entity.User;
import socialnet.com.entity.Message;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
    void deleteMessageById(Long id);
    List<Message> findByUserFrom(User user);
    List<Message> findByUserTo(User user);
    Optional<Message> findById (Long id);

}