package socialnet.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnet.com.Service.CommentService;
import socialnet.com.Service.MessageService;
import socialnet.com.Service.UserService;
import socialnet.com.dto.UserDTO;
import socialnet.com.entity.Comment;
import socialnet.com.entity.Following;
import socialnet.com.entity.Post;
import socialnet.com.entity.User;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allusers = userService.findAllUsers();
        return ResponseEntity.ok(allusers);
    }
    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    } //передалать в ДТО
    @PutMapping
    public void updateUser(@RequestBody UserDTO userDTO) { userService.updateUser(userDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id);
    }
//    @GetMapping("/{userId}/followings")
//    public ResponseEntity<?> findAllFollowing(@PathVariable User following, @PathVariable String userId){ //он подсказал
//        List<Following> followingList = userService.findAllFollowing(following);
//        return ResponseEntity.ok(followingList);
//    }


}