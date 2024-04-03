package com.ihfms.healthfinancehub.messagingmodule.messagingservice;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;
import com.ihfms.healthfinancehub.messagingmodule.messageobserver.ChatObserver;
import com.ihfms.healthfinancehub.messagingmodule.messagerepo.MessageRepo;
import org.springframework.stereotype.Service;

@Service
public class ChatService implements ChatObserver {

    private final MessageRepo messageRepo;

    public ChatService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public ChatMessage onMessageReceived(ChatMessage message) {
        messageRepo.addMessage(message);
        return message;
    }
}
