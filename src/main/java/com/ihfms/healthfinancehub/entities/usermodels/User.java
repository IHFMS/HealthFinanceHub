package com.ihfms.healthfinancehub.entities.usermodels;

import lombok.Data;

@Data
public abstract class User {

    private Long userID;
    private String username;
    private String email;
    private String password;
    private Role role;

    public void writeName(){
        System.out.println();
    }

}
