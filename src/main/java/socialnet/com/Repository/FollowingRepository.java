package socialnet.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.entity.Following;
import socialnet.com.entity.User;

import java.util.List;

@Repository
public interface FollowingRepository extends JpaRepository<Following,Integer> {
//  List<Following> saveFollowing (Following following);
    void deleteFollowingById(Long id);
}
