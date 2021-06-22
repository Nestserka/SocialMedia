package socialnet.com.Service;

import socialnet.com.entity.Comment;
import socialnet.com.entity.Following;
import socialnet.com.entity.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    //void addFollowing (User following);
    List<User> findAllUsers();
//    List<Following> findAllFollowing(User following);
}






