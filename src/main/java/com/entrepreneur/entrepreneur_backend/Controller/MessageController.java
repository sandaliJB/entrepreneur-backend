package com.entrepreneur.entrepreneur_backend.Controller;


import com.entrepreneur.entrepreneur_backend.Models.Message;
import com.entrepreneur.entrepreneur_backend.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @GetMapping("/between")
    public List<Message> getMessagesBetweenUsers(@RequestParam String senderId, @RequestParam String receiverId) {
        return messageService.getMessagesBetweenUsers(senderId, receiverId);
    }

    @GetMapping("/received")
    public List<Message> getReceivedMessages(@RequestParam String receiverId) {
        return messageService.getReceivedMessages(receiverId);
    }

    @GetMapping("/sent")
    public List<Message> getSentMessages(@RequestParam String senderId) {
        return messageService.getSentMessages(senderId);
    }
}
