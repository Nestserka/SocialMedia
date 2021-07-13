package socialnet.com.Service;

import socialnet.com.dto.UserDTO;
import socialnet.com.entity.Comment;
import socialnet.com.entity.Following;
import socialnet.com.entity.User;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(Long id);
    //void addFollowing (User following);
    List<User> findAllUsers();
//    List<Following> findAllFollowing(User following);
}






