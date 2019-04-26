package com.uabc.database.example.examplejpa.model;

import com.uabc.database.example.examplejpa.entity.User;
import lombok.Data;

@Data
public class UserRoleModel {
    private int userRoleId;
    private String user;
    private String role;

    public UserRoleModel(){

    }
}
