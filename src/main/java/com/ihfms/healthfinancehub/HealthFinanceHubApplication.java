package com.ihfms.healthfinancehub;

import com.ihfms.healthfinancehub.authmodule.models.userfactories.AdminUserFactory;
import com.ihfms.healthfinancehub.authmodule.models.userfactories.UserFactory;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.*;
import com.ihfms.healthfinancehub.entities.datasource.DBConfig;
import com.ihfms.healthfinancehub.messagingmodule.messageobservable.ChatObservable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class HealthFinanceHubApplication {

    public static void main(String[] args) {

//        ChatObservable chatObservable = new ChatObservable();
//
//        AdminStaff adminStaff = new AdminStaff();
//        adminStaff.broadcastMessage("Important update for all members");
//
//        HealthProvider healthProvider = new HealthProvider();
//
//        FinanceStaff financeStaff = new FinanceStaff();
//
//        chatObservable.subscribe(adminStaff);
//        chatObservable.subscribe(healthProvider);
//        chatObservable.subscribe(financeStaff);

//        DBConfig dbConnection = DBConfig.getInstance();
//        Connection conn = dbConnection.getConnection();
//        System.out.println(conn);

        SpringApplication.run(HealthFinanceHubApplication.class, args);
    }


}
