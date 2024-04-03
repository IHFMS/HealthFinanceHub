package com.ihfms.healthfinancehub.authmodule.models.usermodels;

import lombok.Data;

@Data

public class User {

    private Long userID;
    private String username;
    private String email;
    private String password;
    private Role role;

}
