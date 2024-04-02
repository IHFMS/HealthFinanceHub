package com.ihfms.healthfinancehub.authmodule.services;

import com.ihfms.healthfinancehub.authmodule.models.userfactories.AdminUserFactory;
import com.ihfms.healthfinancehub.authmodule.models.userfactories.UserFactory;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.AdminStaff;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.Role;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.repos.UserRepo;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

@Service
public class AdminService {

    private UserRepo userRepo;

    public AdminService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    UserFactory userFactory = new AdminUserFactory();
    @Getter
    AdminStaff adminStaff;

    public User registerAdminUser(String username, String email, String password) throws SQLException {
        User user = userFactory.createUser(Role.ADMIN);

        // to generate a random UUID for an admin
        UUID uniqueKey = UUID.randomUUID();
        // to generate a random UUID for a user
        Random rand = new Random();

        adminStaff = (AdminStaff) user;
        adminStaff.setUserID(rand.nextLong(1000));
        adminStaff.setUsername(username);
        adminStaff.setEmail(email);
        adminStaff.setPassword(password);
        adminStaff.setAdminId(uniqueKey.toString());

        userRepo.insertUser(user);

        return adminStaff;
    }

}
