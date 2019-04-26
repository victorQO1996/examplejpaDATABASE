package com.uabc.database.example.examplejpa.services.impl;

import com.uabc.database.example.examplejpa.components.UserRoleConverter;
import com.uabc.database.example.examplejpa.entity.UserRole;
import com.uabc.database.example.examplejpa.model.UserRoleModel;
import com.uabc.database.example.examplejpa.repository.UserRoleRepository;
import com.uabc.database.example.examplejpa.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    @Qualifier("userRoleConverter")
    private UserRoleConverter userRoleConverter;

    @Autowired
    @Qualifier("userRoleRepository")
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRoleModel addUserRole(UserRoleModel userRoleModel) {
        UserRole temp = userRoleConverter.convertUserRoleModel2UserRole(userRoleModel);
        UserRole userRole = userRoleRepository.save(temp);
        return userRoleConverter.convertUserRole2UserRoleModel(userRole);
    }

    @Override
    public List<UserRoleModel> listAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        List<UserRoleModel> userRolesModel = new ArrayList();
        for(UserRole userRole : userRoles)
            userRolesModel.add(userRoleConverter.convertUserRole2UserRoleModel(userRole));
        return userRolesModel;
    }

    @Override
    public UserRole findUserRoleById(int id) {
        return userRoleRepository.findByUserRoleId(id);
    }

    public UserRoleModel findUserRoleByIdModel(int id) {
        return userRoleConverter.convertUserRole2UserRoleModel(findUserRoleById(id));
    }

    @Override
    public void removeUserRole(int id) {
        UserRole userRole = findUserRoleById(id);
        if(userRole != null)
            userRoleRepository.delete(findUserRoleById(id));
    }
}
