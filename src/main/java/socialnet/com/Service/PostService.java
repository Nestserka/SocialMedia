package socialnet.com.Service;

import socialnet.com.entity.Post;

import java.util.List;

public interface PostService  {
    void createPost(Post post);
    void updatePost(Post post);
    void deletePost(Long id);

    List<Post> findAllPosts();
    List<Post> getPostsOfUser(Long userId);
}
