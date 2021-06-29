package socialnet.com.Service.impl;

import org.springframework.stereotype.Service;
import socialnet.com.Repository.FollowingRepository;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.FollowingService;
import socialnet.com.dto.FollowingDTO;
import socialnet.com.entity.Following;
import socialnet.com.entity.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class FollowingServiceImpl  implements FollowingService {
    private static final Logger LOGGER = Logger.getLogger( FollowingServiceImpl.class.getName() );

    private final FollowingRepository followingRepository;
    private final UserRepository userRepository;

    public FollowingServiceImpl(FollowingRepository followingRepository, UserRepository userRepository) {
        this.followingRepository = followingRepository;
        this.userRepository = userRepository;
    }



    @Override
    public List<Following> findAllFollowing() {
        return followingRepository.findAll();
    }

    @Override
    public void deleteFollowing(Long id) {
        followingRepository.deleteFollowingById(id);
    }

    @Override
    public void saveFollowing(FollowingDTO followingDTO) {
     Following followingUser = new Following();
        Optional<User> userFromOptional = userRepository.findById(followingDTO.getIdFrom());
        User userFrom = null;
        if (userFromOptional.isPresent()){
            userFrom = userFromOptional.get();
        }
        assert userFrom != null;
        Optional<User> userToOptional = userRepository.findById(followingDTO.getIdTo());
        User userTo = null;
        if (userToOptional.isPresent()){
            userTo = userToOptional.get();
        }
        assert userTo != null;

        followingUser.setFollowing(userTo);
        followingRepository.save(followingUser);

        List <Following> followings = userFrom.getFollowing();
        if (followings != null && followings.size() > 0) {
            followings.add(followingUser);
        }
        else  {
            followings = new ArrayList<>();
            followings.add(followingUser);
        }

        userFrom.setFollowing(followings);
        userRepository.save(userFrom);
    }

//    @Override
//    public List<Following> saveFollowing(Long id) {
//        return followingRepository.saveFollowing(id);
//    }

}
