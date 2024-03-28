package com.ihfms.healthfinancehub;

import com.ihfms.healthfinancehub.entities.userfactories.AdminUserFactory;
import com.ihfms.healthfinancehub.entities.userfactories.FinanceUserFactory;
import com.ihfms.healthfinancehub.entities.userfactories.HealthUserFactory;
import com.ihfms.healthfinancehub.entities.userfactories.UserFactory;
import com.ihfms.healthfinancehub.entities.usermodels.Role;
import com.ihfms.healthfinancehub.entities.usermodels.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthFinanceHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthFinanceHubApplication.class, args);

        UserFactory userFactory = new AdminUserFactory();
        User adminStaff = userFactory.createUser(Role.ADMIN);
        adminStaff.writeName();

        userFactory = new FinanceUserFactory();
        User financeStaff = userFactory.createUser(Role.FINANCE);
        financeStaff.writeName();

        userFactory = new HealthUserFactory();
        User healthProvider = userFactory.createUser(Role.HEALTH);
        healthProvider.writeName();
    }

}
