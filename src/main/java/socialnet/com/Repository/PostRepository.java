package socialnet.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.entity.User;
import socialnet.com.entity.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    void deletePostById(Long id);
    Optional<Post> findById (Long id);
    List<Post> findPostByUserOrderById(User user);
    List<Post> findAllByOrderByIdDesc();
    List<Post> findAllByUser_Id(Long id);
    Optional <Post> findLikesById (Long id);
}


