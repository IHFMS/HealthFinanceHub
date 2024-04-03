package com.ihfms.healthfinancehub.messagingmodule.messagecontroller;

import com.ihfms.healthfinancehub.messagingmodule.messageobservable.ChatObservable;
import com.ihfms.healthfinancehub.messagingmodule.messagingservice.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("health-hub")
public class SubscribeController{

    private final ChatObservable chatObservable;
    private final ChatService chatService;

    public SubscribeController(ChatObservable chatObservable, ChatService chatService) {
        this.chatObservable = chatObservable;
        this.chatService = chatService;
    }

    @PostMapping("/subscribe")
    public String subscribeUser() {
        chatObservable.subscribe(chatService);
        return "User subscribed successfully";
    }

    @PostMapping("/unsubscribe")
    public String unsubscribeUser() {
//        chatObservable.unsubscribe();
        return "User unsubscribed successfully";
    }

}
