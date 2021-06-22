package socialnet.com.Service;

import org.springframework.stereotype.Service;

import socialnet.com.entity.Message;
import socialnet.com.entity.Post;
import socialnet.com.entity.User;

import java.util.List;

@Service
public interface MessageService {
    void createMessage(Message message);
    void deleteMessage(Long id);
    List<Message> findConversation(User userFrom, User userTo);
    Message getRecentMessage(Long id);
}