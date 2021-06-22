package socialnet.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.entity.User;
import socialnet.com.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findPostByUserOrderById(User user);
    List<Post> findAllByOrderByIdDesc();
    List<Post> findAllByUser_Id(Long id);
    //page!!!
}


