package com.ihfms.healthfinancehub.authmodule.models.userfactories;

import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.HealthProvider;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.Role;

public class HealthUserFactory implements UserFactory{
    @Override
    public User createUser(Role role) {
        if (role == Role.HEALTH){
            HealthProvider healthProvider = new HealthProvider();
            healthProvider.setRole(role);
            return healthProvider;
        }
        return null;
    }
}
