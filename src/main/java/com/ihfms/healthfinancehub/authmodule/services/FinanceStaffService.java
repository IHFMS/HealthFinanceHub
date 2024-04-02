package com.ihfms.healthfinancehub.authmodule.services;

import com.ihfms.healthfinancehub.authmodule.models.userfactories.FinanceUserFactory;
import com.ihfms.healthfinancehub.authmodule.models.userfactories.UserFactory;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.*;
import com.ihfms.healthfinancehub.authmodule.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Random;

@Service
public class FinanceStaffService {

    private UserRepo userRepo;

    public FinanceStaffService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    UserFactory userFactory = new FinanceUserFactory();
    FinanceStaff financeStaff;

    public User registerFinanceStaff(String username, String email, String password) throws SQLException {
        User user = userFactory.createUser(Role.FINANCE);

        // to generate a random UUID for a user
        Random rand = new Random();

        financeStaff = (FinanceStaff) user;
        financeStaff.setUserID(rand.nextLong(1000));
        financeStaff.setUsername(username);
        financeStaff.setEmail(email);
        financeStaff.setPassword(password);

        userRepo.insertUser(user);

        return financeStaff;
    }

}
