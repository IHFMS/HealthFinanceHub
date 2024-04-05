package com.ihfms.healthfinancehub.messagingmodule.messagecontroller;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;

import com.ihfms.healthfinancehub.messagingmodule.messageobservable.ChatObservable;
import com.ihfms.healthfinancehub.messagingmodule.messagingservice.ChatService;
import org.springframework.web.bind.annotation.*;

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
    public ChatMessage sendMessage(@RequestBody String messageContent, @RequestParam String sender) {
        ChatMessage message = new ChatMessage();
        message.setSender(sender);
        message.setContent(messageContent);
        message.setTimestamp(LocalTime.now());

        chatObservable.notifyChatObservers(message);

        return message;
    }

}
