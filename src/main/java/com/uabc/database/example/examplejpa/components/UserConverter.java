package com.uabc.database.example.examplejpa.components;

import com.uabc.database.example.examplejpa.entity.User;
import com.uabc.database.example.examplejpa.model.UserModel;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter {
    public User convertUserModel2User(UserModel userModel) {
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setUserRoles(userModel.getUserRoles());
        user.setPassword(userModel.getPassword());
        user.setEnabled(userModel.isEnabled());
        return user;
    }

    public UserModel convertUser2UserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setPassword(user.getPassword());
        userModel.setUsername(user.getUsername());
        userModel.setUserRoles(user.getUserRoles());
        userModel.setEnabled(user.isEnabled());
        return userModel;
    }
}
