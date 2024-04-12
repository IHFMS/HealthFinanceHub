package com.ihfms.healthfinancehub.messagingmodule.messagecontroller;

import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;

import com.ihfms.healthfinancehub.messagingmodule.messageobservable.ChatObservable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@RestController
@RequestMapping("health-hub")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

    private final ChatObservable chatObservable;
    public MessageController(ChatObservable chatObservable) {
        this.chatObservable = chatObservable;
    }

    // broadcasting the message
    @PostMapping("/sendMessage")
    public ModelAndView sendMessage(
            @RequestParam("messageContent") String messageContent,
            @RequestParam String sender,
            ModelMap modelMap
    ) {
        ChatMessage message = new ChatMessage();
        message.setSender(sender);
        message.setContent(messageContent);
        message.setTimestamp(LocalTime.now());

        chatObservable.notifyChatObservers(message);

        modelMap.addAttribute("messages", message);

        return new ModelAndView("redirect:/health-hub/receive-messages");
    }

}
