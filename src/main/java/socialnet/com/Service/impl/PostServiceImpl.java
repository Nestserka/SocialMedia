package socialnet.com.Service.impl;

import org.springframework.stereotype.Service;
import socialnet.com.Repository.CommentRepository;
import socialnet.com.Repository.PostRepository;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.PostService;
import socialnet.com.entity.Post;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private static final Logger LOGGER = Logger.getLogger( PostServiceImpl.class.getName() );

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostServiceImpl(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository=userRepository;
        this.postRepository=postRepository;
        this.commentRepository=commentRepository;
    }

    @Override
    public void createPost(Post post) {
        post.setCreatedDate(new Date());
        postRepository.save(post);

    }

    @Override
    public void updatePost(Post post) {

        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deletePostById(id);

    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostsOfUser(Long userId) {
     return postRepository.findAllByUser_Id(userId);
    }
}
