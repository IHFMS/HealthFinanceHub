package com.ihfms.healthfinancehub.authmodule.models.userfactories;

import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.Role;

public interface UserFactory {
    User createUser(Role role);
}
