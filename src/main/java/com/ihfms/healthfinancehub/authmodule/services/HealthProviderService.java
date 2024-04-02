package com.ihfms.healthfinancehub.authmodule.services;

import com.ihfms.healthfinancehub.authmodule.models.userfactories.HealthUserFactory;
import com.ihfms.healthfinancehub.authmodule.models.userfactories.UserFactory;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.HealthProvider;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.Role;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.repos.UserRepo;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Random;

@Service
public class HealthProviderService {

    private UserRepo userRepo;

    public HealthProviderService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    UserFactory userFactory = new HealthUserFactory();
    @Getter
    HealthProvider healthProvider;

    public User registerHealthProvider(String username, String email, String password, String specialization) throws SQLException {
        User user = userFactory.createUser(Role.HEALTH);

        // to generate a random UUID for a user
        Random rand = new Random();

        healthProvider = (HealthProvider) user;
        healthProvider.setUserID(rand.nextLong(1000));
        healthProvider.setUsername(username);
        healthProvider.setEmail(email);
        healthProvider.setPassword(password);
        healthProvider.setSpecialization(specialization);

        userRepo.insertUser(user);

        return healthProvider;
    }
//    User healthProvider = userFactory.createUser(Role.HEALTH);
//        healthProvider.writeName();

}
