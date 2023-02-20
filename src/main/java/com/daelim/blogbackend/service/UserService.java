package com.daelim.blogbackend.service;

import com.daelim.blogbackend.entity.User;
import com.daelim.blogbackend.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class UserService{
    ObjectMapper objMpr = new ObjectMapper();
    @Autowired()
    UserRepository userRepository;

    public User signUp(Map<String, Object> userObj) {
        User user = objMpr.convertValue(userObj, User.class);
        userRepository.save(user);
        return user;
    }

    public void login() {
    }

    public void isLogin() {
    }

    public void updateUser(Map<String, Object> userObj) {
        User user = objMpr.convertValue(userObj, User.class);
        userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
