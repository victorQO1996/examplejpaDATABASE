package com.uabc.database.example.examplejpa.services.impl;

import com.uabc.database.example.examplejpa.components.UserConverter;
import com.uabc.database.example.examplejpa.entity.User;
import com.uabc.database.example.examplejpa.model.UserModel;
import com.uabc.database.example.examplejpa.repository.UserRepository;
import com.uabc.database.example.examplejpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;

    @Override
    public UserModel addUser(UserModel userModel) {
        User temp = userConverter.convertUserModel2User(userModel);
        User user = userRepository.save(temp);
        return userConverter.convertUser2UserModel(user);
    }

    @Override
    public List<UserModel> listAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserModel> usersModel = new ArrayList();
        for(User user : users)
            usersModel.add(userConverter.convertUser2UserModel(user));
        return usersModel;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel findUserByUsernameModel(String username) {
        return userConverter.convertUser2UserModel(findUserByUsername(username));
    }

    @Override
    public void removeUser(String username) {
        User user = findUserByUsername(username);
        if(user != null)
            userRepository.delete(findUserByUsername(username));
    }
}
