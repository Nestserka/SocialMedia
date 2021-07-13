package socialnet.com.Service;

import socialnet.com.dto.PostDTO;
import socialnet.com.entity.Post;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PostService  {
    void createPost(PostDTO postDTO) throws IOException;
    Post updatePost(Post post);
    void deletePost(Long id);
    void putLike(Long postId);

    List<Post> findAllPosts();
    List<PostDTO> getPostsOfUser(Long userId) throws IOException;
}
