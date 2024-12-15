package com.entrepreneur.entrepreneur_backend.Service;

import com.entrepreneur.entrepreneur_backend.Models.Message;

import java.util.List;

public interface MessageService {
    Message sendMessage(Message message);
    List<Message> getMessagesBetweenUsers(String senderId, String receiverId);
    List<Message> getReceivedMessages(String receiverId);
    List<Message> getSentMessages(String senderId);
}
