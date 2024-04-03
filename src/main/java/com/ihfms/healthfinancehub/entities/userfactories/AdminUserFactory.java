package com.ihfms.healthfinancehub.entities.userfactories;

import com.ihfms.healthfinancehub.entities.usermodels.AdminStaff;
import com.ihfms.healthfinancehub.entities.usermodels.Role;
import com.ihfms.healthfinancehub.entities.usermodels.User;

public class AdminUserFactory implements UserFactory{

    @Override
    public User createUser(Role role) {
        if (role == Role.ADMIN){
            AdminStaff admin = new AdminStaff();
            admin.setRole(role);
            return admin;
        }
        return null;
    }
}
