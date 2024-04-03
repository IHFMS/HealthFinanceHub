package com.ihfms.healthfinancehub.messagingmodule.messagecontroller;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;
import com.ihfms.healthfinancehub.messagingmodule.messagerepo.MessageRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// models a chat room that users can go to, to receive messages
@RestController
@RequestMapping("health-hub")
public class ChatController {

    private final MessageRepo messageRepo;

    public ChatController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/receive-message")
    public List<ChatMessage> receiveMessage() {
        return messageRepo.getMessages();
    }

}
