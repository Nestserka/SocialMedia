package socialnet.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.dto.UserDTO;
import socialnet.com.entity.Following;
import socialnet.com.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    void deleteUserById(Long id);
    void save(UserDTO userDTO);
    Optional<User> findByEmail(String email);
//
//    User findUserByEmail(String email);

}

