package socialnet.com.Service;

import org.springframework.stereotype.Service;

import socialnet.com.dto.MessageDTO;
import socialnet.com.entity.Comment;
import socialnet.com.entity.Message;
import socialnet.com.entity.Post;
import socialnet.com.entity.User;

import java.util.List;

@Service
public interface MessageService {
    void createMessage(MessageDTO messageDTO);
    void deleteMessage(Long id);
    void updateMessage(Message message);
    List<Message> findConversation(User userFrom, User userTo);
    Message getRecentMessage(Long id);
    List<Message> findAllMessages();
}