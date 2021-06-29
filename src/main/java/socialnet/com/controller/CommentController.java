package socialnet.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnet.com.Service.CommentService;
import socialnet.com.dto.CommentDTO;
import socialnet.com.entity.Comment;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/comments")

public class CommentController {


    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity <List<Comment>>  getAllComments() {
     List<Comment> allComments = commentService.findAllComments();
        return ResponseEntity.ok(allComments);
    }
    @PostMapping
    public void createComment(@RequestBody CommentDTO commentDTO) {
      commentService.createComment(commentDTO);

    }
    @PutMapping
    public void updateComment(@RequestBody Comment usersComment) {
        commentService.updateComment(usersComment);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentByID(@PathVariable Long id){
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }


}