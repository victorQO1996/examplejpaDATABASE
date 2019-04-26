package com.uabc.database.example.examplejpa.components;

import com.uabc.database.example.examplejpa.entity.User;
import com.uabc.database.example.examplejpa.entity.UserRole;
import com.uabc.database.example.examplejpa.model.UserRoleModel;
import com.uabc.database.example.examplejpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userRoleConverter")
public class UserRoleConverter {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    public UserRole convertUserRoleModel2UserRole(UserRoleModel userRoleModel) {
        UserRole userRole = new UserRole();
        userRole.setRole(userRoleModel.getRole());
        User user = userRepository.findByUsername(userRoleModel.getUser());
        userRole.setUser(user);
        userRole.setUserRoleId(userRoleModel.getUserRoleId());
        return userRole;
    }

    public UserRoleModel convertUserRole2UserRoleModel(UserRole userRole) {
        UserRoleModel userRoleModel = new UserRoleModel();
        userRoleModel.setRole(userRole.getRole());
        userRoleModel.setUser(userRole.getUser().getUsername());
        userRoleModel.setUserRoleId(userRole.getUserRoleId());
        return userRoleModel;
    }
}
