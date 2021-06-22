package socialnet.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnet.com.Service.MessageService;
import socialnet.com.entity.Comment;
import socialnet.com.entity.Message;
import socialnet.com.entity.User;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/messages")

public class MessageController {


    @Autowired
    MessageService messageService;

    @GetMapping("/{id}/conversations")
    public ResponseEntity<List<Message>> findConversation(@PathVariable User userFrom, User userTo){
       List<socialnet.com.entity.Message> message = messageService.findConversation(userFrom, userTo);
        return ResponseEntity.ok(message);
    }
    @PostMapping
    public void createMessage(@RequestBody Message message){
        messageService.createMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Message> getRecentMessage(@PathVariable Long id){
       Message message =messageService.getRecentMessage(id);
        return ResponseEntity.ok(message);
    }



}
