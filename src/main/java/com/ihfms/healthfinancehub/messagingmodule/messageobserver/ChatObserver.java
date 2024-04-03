package com.ihfms.healthfinancehub.messagingmodule.messageobserver;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;

public interface ChatObserver {
    ChatMessage onMessageReceived(ChatMessage message);
}
