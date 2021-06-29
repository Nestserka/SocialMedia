package socialnet.com.Service;

import org.springframework.stereotype.Service;
import socialnet.com.dto.FollowingDTO;
import socialnet.com.entity.Following;
import socialnet.com.entity.Post;
import socialnet.com.entity.User;

import java.util.List;

@Service
public interface FollowingService {
    void deleteFollowing(Long id);
   void saveFollowing(FollowingDTO followingDTO);

    List<Following> findAllFollowing();

}
