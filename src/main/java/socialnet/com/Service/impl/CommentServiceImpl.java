package socialnet.com.Service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import socialnet.com.Repository.CommentRepository;
import socialnet.com.Repository.PostRepository;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.CommentService;
import socialnet.com.controller.PostController;
import socialnet.com.dto.CommentDTO;
import socialnet.com.entity.Comment;
import socialnet.com.entity.Post;
import socialnet.com.entity.User;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private static final Logger LOGGER = Logger.getLogger( CommentServiceImpl.class.getName() );

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository=commentRepository;
        this.userRepository=userRepository;
        this.postRepository=postRepository;
    }

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void createComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        Optional<Post> postOptional = postRepository.findById(commentDTO.getPostId());
        Post post = null;
        if (postOptional.isPresent()) {
            post = postOptional.get();
        }
            assert post != null;
        comment.setPost(post);
        comment.setText(commentDTO.getText());
        comment.setCreatedDate(new Date());
            commentRepository.save(comment);
        }

    @Override
    public void updateComment(Comment usersComment) {
        commentRepository.save(usersComment);

    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteCommentById(id);

    }

    @Override
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        Comment commentopt = comment.get();
        return commentopt;
    }

}