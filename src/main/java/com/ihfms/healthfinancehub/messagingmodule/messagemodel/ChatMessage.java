package com.ihfms.healthfinancehub.messagingmodule.messagemodel;

import lombok.Data;

import java.util.Date;

@Data
public class ChatMessage {

    private String sender;
    private String content;
    private MessageType type;
    private Date timestamp;
}
