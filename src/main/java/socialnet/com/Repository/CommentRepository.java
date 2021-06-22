package socialnet.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.entity.Post;
import socialnet.com.entity.User;
import socialnet.com.entity.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
   Optional<Comment> findById (Long id);
   void deleteCommentById(Long id);

}
