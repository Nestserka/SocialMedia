package socialnet.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnet.com.Service.MessageService;
import socialnet.com.Service.UserService;
import socialnet.com.dto.MessageDTO;
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

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity <List<Message>>  getAllMessages() {
        List<Message> allMessages = messageService.findAllMessages();
        return ResponseEntity.ok(allMessages);
    }

    @GetMapping("/{id}/conversations")
    public ResponseEntity<List<Message>> findConversation(@PathVariable User userFrom, User userTo){
       List<socialnet.com.entity.Message> message = messageService.findConversation(userFrom, userTo);
        return ResponseEntity.ok(message);
    }
    @PostMapping
    public void createMessage(@RequestBody MessageDTO messageDTO){
        messageService.createMessage(messageDTO);
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
    @PutMapping
    public void updateMessage(@RequestBody Message message) {
        messageService.updateMessage(message);
    }


}
