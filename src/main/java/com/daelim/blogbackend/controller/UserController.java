package com.daelim.blogbackend.controller;

import com.daelim.blogbackend.entity.User;
import com.daelim.blogbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody Map<String, Object> userObj) {
        return userService.signUp(userObj);
    }

    @GetMapping("/login")
    public void login() {
        userService.login();
    }

    @GetMapping("/isLogin")
    public void isLogin() {
        userService.isLogin();
    }

    @PutMapping("/modify")
    public void updateUser(@RequestBody Map<String,Object> userObj) {
        userService.updateUser(userObj);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
