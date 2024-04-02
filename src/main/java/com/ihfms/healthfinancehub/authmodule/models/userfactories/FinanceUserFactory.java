package com.ihfms.healthfinancehub.authmodule.models.userfactories;

import com.ihfms.healthfinancehub.authmodule.models.usermodels.FinanceStaff;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.Role;

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
