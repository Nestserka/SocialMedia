package socialnet.com.Service.impl;

import org.springframework.stereotype.Service;
import socialnet.com.Repository.MessageRepository;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.MessageService;
import socialnet.com.entity.Comment;
import socialnet.com.entity.Message;
import socialnet.com.entity.User;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional  //DONT FORGET!!!!!!!!!
public class MessageServiceImpl  implements MessageService {
    private static final Logger LOGGER = Logger.getLogger( MessageServiceImpl.class.getName() );

    public MessageServiceImpl(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository=messageRepository;
        this.userRepository=userRepository;
    }

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    public void createMessage(Message message) {
        message.setCreatedDate((java.sql.Date) new Date());
      //  message.setUserfrom(message.getUserfrom()); думаю он тоже пройдет автоматом
        messageRepository.save(message);

    }


    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id.intValue());

    }

    @Override
    public List<Message> findConversation(User userFrom, User userTo) {
        return messageRepository.findByUserFrom(userFrom);
    }

    @Override
    public Message getRecentMessage(Long id) {
        Optional<Message> message = messageRepository.findById(id.intValue());
        Message message1 = message.get();
        return  message1;
    }
}