package com.ihfms.healthfinancehub.authmodule.models.usermodels;

import com.ihfms.healthfinancehub.entities.reportmodels.Report;
import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;
import lombok.*;

import java.util.Date;

// can be made controller or methods be abstracted
@Data
public class AdminStaff extends User {

    private String adminId;

    public void writeName(){
        System.out.println("From the AdminStaff class");
    }

    private void registerPatient(Patient patient){

    }
    private Report generateReport(String reportType){
        return new Report(); // can be abstracted
    }

    public void broadcastMessage(String messageContent) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setContent(messageContent);
        chatMessage.setSender("Admin");
        chatMessage.setTimestamp(new Date());
    }

}
