package com.ihfms.healthfinancehub.authmodule.models.userfactories;

import com.ihfms.healthfinancehub.authmodule.models.usermodels.AdminStaff;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.Role;

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
