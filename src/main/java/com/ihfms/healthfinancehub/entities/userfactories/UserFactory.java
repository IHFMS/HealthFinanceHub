package com.ihfms.healthfinancehub.entities.userfactories;

import com.ihfms.healthfinancehub.entities.usermodels.Role;
import com.ihfms.healthfinancehub.entities.usermodels.User;

public interface UserFactory {
    User createUser(Role role);
}
