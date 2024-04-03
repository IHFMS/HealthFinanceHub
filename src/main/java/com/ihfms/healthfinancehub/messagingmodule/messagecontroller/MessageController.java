package com.ihfms.healthfinancehub.messagingmodule.messagecontroller;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;

import com.ihfms.healthfinancehub.messagingmodule.messageobservable.ChatObservable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("health-hub")
public class MessageController {

    private final ChatObservable chatObservable;

    public MessageController(ChatObservable chatObservable) {
        this.chatObservable = chatObservable;
    }

    // broadcasting message
    @PostMapping("/sendMessage")
    public ChatMessage sendMessage(@RequestBody String messageContent) {
        ChatMessage message = new ChatMessage();
        message.setContent(messageContent);
        message.setTimestamp(LocalTime.now());
        chatObservable.notifyChatObservers(message);

        return message;
    }

}
