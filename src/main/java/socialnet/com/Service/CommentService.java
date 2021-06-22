package socialnet.com.Service;

import socialnet.com.entity.Comment;

import java.util.List;

public interface CommentService  {
    void createComment(Comment usersComment);
    void updateComment(Comment usersComment);
    void deleteComment(Long id);

    List<Comment> findAllComments();
    Comment getCommentById(Long id);
}
