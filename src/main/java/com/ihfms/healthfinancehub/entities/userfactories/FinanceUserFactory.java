package com.ihfms.healthfinancehub.entities.userfactories;

import com.ihfms.healthfinancehub.entities.usermodels.AdminStaff;
import com.ihfms.healthfinancehub.entities.usermodels.FinanceStaff;
import com.ihfms.healthfinancehub.entities.usermodels.Role;
import com.ihfms.healthfinancehub.entities.usermodels.User;

public class FinanceUserFactory implements UserFactory{

    @Override
    public User createUser(Role role) {
        if (role == Role.FINANCE){
            FinanceStaff financeStaff = new FinanceStaff();
            financeStaff.setRole(role);
            return financeStaff;
        }
        return null;
    }
}
