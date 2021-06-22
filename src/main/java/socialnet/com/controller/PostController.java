package socialnet.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnet.com.Service.PostService;
import socialnet.com.entity.Post;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> allPosts = postService.findAllPosts();
        return ResponseEntity.ok(allPosts);
    }
    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }
    @PutMapping
    public void updatePost(@RequestBody Post post) {
        postService.updatePost(post);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
    @GetMapping("/{userId}/posts")
    public ResponseEntity<?> getPostofUser(@PathVariable Long userId){
        List<Post> postList = postService.getPostsOfUser(userId);
        return ResponseEntity.ok(postList);
    }
}
