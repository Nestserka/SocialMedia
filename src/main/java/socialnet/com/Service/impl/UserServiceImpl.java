package socialnet.com.Service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.UserService;
import socialnet.com.dto.UserDTO;
import socialnet.com.entity.Following;
import socialnet.com.entity.Message;
import socialnet.com.entity.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional  //DONT FORGET!!!!!!!!!
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger( UserServiceImpl.class.getName() );
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User newUser = new User();
      //  List <Following> followingList = new ArrayList<>();
        newUser.setEmail(userDTO.getEmail());
        newUser.setLastName(userDTO.getLastName());
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setPassword(userDTO.getPassword());
        newUser.setFollowing(new ArrayList<Following>());
        newUser.setMessages(new HashSet<Message>());
        userRepository.save(newUser);
        }


    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(userDTO.getId());
        User user = null;
        if (userOptional.isPresent()){
            user = userOptional.get();
        }
        assert user != null;
//        user.setEmail(userDTO.getEmail());
//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());
//        user.setPassword(userDTO.getPassword());
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


//    @Override
//    public List<Following> findAllFollowing(User following) {
//        return userRepository.findAllFollowing(following); //edited
//    }
}
