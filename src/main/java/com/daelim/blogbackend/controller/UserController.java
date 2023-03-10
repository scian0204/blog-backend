package com.daelim.blogbackend.controller;

import com.daelim.blogbackend.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return userService.signUp(userObj, session);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return userService.login(userObj, session);
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("userId");
    }

    @GetMapping("/isLogin")
    public Object isLogin(HttpSession session) {
        return session.getAttribute("userId");
    }

    @PutMapping("/modify")
    public void updateUser(@RequestBody Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        userService.updateUser(userObj, session);
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestBody Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return userService.deleteUser(userObj, session);
    }
}
