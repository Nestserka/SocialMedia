package socialnet.com.Service.impl;

import org.springframework.stereotype.Service;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.UserService;
import socialnet.com.entity.Following;
import socialnet.com.entity.User;

import javax.transaction.Transactional;
import java.util.List;
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
    public void createUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void updateUser(User user) {
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
