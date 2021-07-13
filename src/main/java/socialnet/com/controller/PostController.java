package socialnet.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import socialnet.com.Service.PostService;
import socialnet.com.dto.PostDTO;
import socialnet.com.entity.Post;

import java.io.IOException;
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

    @GetMapping("/{postId}/likes")
    public void putLike(@PathVariable Long postId) {
        //   List<Post> likes = postService.getLikes(postId);
        //   return ResponseEntity.ok(likes);
        postService.putLike(postId);

    }

    @PostMapping
    public void createPost(@RequestBody PostDTO postDTO) throws IOException {
        postService.createPost(postDTO);
    } //PostDTO

    @PutMapping
    public void updatePost(@RequestBody Post post) {
        postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPostofUser(@PathVariable Long userId) throws IOException {
        List<PostDTO> postListDTO = postService.getPostsOfUser(userId);
        return ResponseEntity.ok(postListDTO);
    }
}
