package com.entrepreneur.entrepreneur_backend.Implementation;

import com.entrepreneur.entrepreneur_backend.Models.Message;
import com.entrepreneur.entrepreneur_backend.Repository.MessageRepository;
import com.entrepreneur.entrepreneur_backend.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesBetweenUsers(String senderId, String receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }

    @Override
    public List<Message> getReceivedMessages(String receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    @Override
    public List<Message> getSentMessages(String senderId) {
        return messageRepository.findBySenderId(senderId);
    }
}
