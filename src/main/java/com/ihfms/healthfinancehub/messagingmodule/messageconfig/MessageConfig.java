package com.ihfms.healthfinancehub.messagingmodule.messageconfig;

import com.ihfms.healthfinancehub.messagingmodule.messageobservable.ChatObservable;
import com.ihfms.healthfinancehub.messagingmodule.messagingservice.ChatService;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    private final ChatObservable chatObservable;
    private final ChatService chatService;

    public MessageConfig(ChatObservable chatObservable, ChatService chatService) {
        this.chatObservable = chatObservable;
        this.chatService = chatService;
    }

    // to add the chat room at runtime
    @PostConstruct
    public void init(){
        chatObservable.subscribe(chatService);
    }

}
