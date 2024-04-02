package com.ihfms.healthfinancehub.authmodule.models.usermodels;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;
import com.ihfms.healthfinancehub.messagingmodule.messageobserver.ChatObserver;
import lombok.Data;

@Data
public class User implements ChatObserver{

    private Long userID;
    private String username;
    private String email;
    private String password;
    private Role role;

    @Override
    public void onMessageReceived(ChatMessage message) {

    }
}
