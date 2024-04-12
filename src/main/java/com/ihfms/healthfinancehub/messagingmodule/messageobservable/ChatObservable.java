package com.ihfms.healthfinancehub.messagingmodule.messageobservable;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;
import com.ihfms.healthfinancehub.messagingmodule.messageobserver.ChatObserver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatObservable {

    private final List<ChatObserver> chatObservers = new ArrayList<>();

    public void subscribe(ChatObserver chatObserver) {
        chatObservers.add(chatObserver);
    }

    public void unsubscribe(ChatObserver chatObserver) {
        chatObservers.remove(chatObserver);
    }

    public void notifyChatObservers(ChatMessage message) {
        for (ChatObserver observer : chatObservers) {
            observer.onMessageReceived(message);
        }
    }
    
}
