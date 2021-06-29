package socialnet.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnet.com.Service.FollowingService;
import socialnet.com.Service.UserService;
import socialnet.com.dto.FollowingDTO;
import socialnet.com.entity.Following;

import java.util.List;

@RestController
@RequestMapping("/followings")
public class FollowingController {

    @Autowired
    UserService userService;

    @Autowired
    FollowingService followingService;

    @GetMapping
    public ResponseEntity<List<Following>> getAllFollowing() {
        List<Following> allFollowing = followingService.findAllFollowing();
        return ResponseEntity.ok(allFollowing);
    }
    @PostMapping
    public void addNewFollowing(@RequestBody FollowingDTO followingDTO) { //prinimat' following
        followingService.saveFollowing(followingDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteFollowing(@PathVariable Long id) {
        followingService.deleteFollowing(id);
    }

}
