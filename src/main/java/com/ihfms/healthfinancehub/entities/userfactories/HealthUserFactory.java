package com.ihfms.healthfinancehub.entities.userfactories;

import com.ihfms.healthfinancehub.entities.usermodels.HealthProvider;
import com.ihfms.healthfinancehub.entities.usermodels.Role;
import com.ihfms.healthfinancehub.entities.usermodels.User;

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
