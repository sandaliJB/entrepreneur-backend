package com.entrepreneur.entrepreneur_backend.Repository;

import com.entrepreneur.entrepreneur_backend.Models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findBySenderIdAndReceiverId(String senderId, String receiverId);
    List<Message> findByReceiverId(String receiverId);
    List<Message> findBySenderId(String senderId);
}
