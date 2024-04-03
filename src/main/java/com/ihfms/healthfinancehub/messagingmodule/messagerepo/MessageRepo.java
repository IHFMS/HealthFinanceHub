package com.ihfms.healthfinancehub.messagingmodule.messagerepo;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepo {

    private final List<ChatMessage> messages = new ArrayList<>();

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

}
