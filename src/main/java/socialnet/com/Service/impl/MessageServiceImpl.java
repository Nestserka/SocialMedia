package socialnet.com.Service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import socialnet.com.Repository.MessageRepository;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.MessageService;
import socialnet.com.dto.MessageDTO;
import socialnet.com.entity.Following;
import socialnet.com.entity.Message;
import socialnet.com.entity.User;

import javax.transaction.Transactional;
import java.util.*;
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
    public void createMessage(MessageDTO messageDTO) {
        Message messageSent = new Message();
        Optional<User> userFromOptional = userRepository.findById(messageDTO.getIdFrom());
        User userFrom = null;
        if (userFromOptional.isPresent()){
            userFrom = userFromOptional.get();
        }
        assert userFrom != null;
        Optional<User> userToOptional = userRepository.findById(messageDTO.getIdTo());
        User userTo = null;
        if (userToOptional.isPresent()){
            userTo = userToOptional.get();
        }
        assert userTo != null;

        messageSent.setUserTo(userTo);
        messageSent.setUserFrom(userFrom);
        messageSent.setContext(messageDTO.getContext());
        messageRepository.save(messageSent);

    }


    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteMessageById(id);

    }

    @Override
    public void updateMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> findConversation(User userFrom, User userTo) {
        return messageRepository.findByUserFrom(userFrom);
    }

    @Override
    public Message getRecentMessage(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        Message message1 = message.get();
        return  message1;
    }

    @Override
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }
}