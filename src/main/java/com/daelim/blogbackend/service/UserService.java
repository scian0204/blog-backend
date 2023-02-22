package com.daelim.blogbackend.service;

import com.daelim.blogbackend.entity.User;
import com.daelim.blogbackend.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService{
    ObjectMapper objMpr = new ObjectMapper();
    @Autowired()
    UserRepository userRepository;

    public String signUp(Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = objMpr.convertValue(userObj, User.class);
        session.setAttribute("userId", user.getUserId());
        user.setPassword(encrypt(user.getPassword()));
        userRepository.save(user);
        return user.getUserId();
    }

    public String login(Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String userId = (String) userObj.get("userId");
        String password = (String) userObj.get("password");

        Optional<User> byUserId = userRepository.findByUserId(userId);
        if (byUserId.isPresent()) {
            User user = byUserId.get();
            if (user.getPassword().equals(encrypt(password))) {
                session.setAttribute("userId", userId);
                return user.getUserId();
            } else {
                return "1"; // id존재 pw틀림
            }
        } else {
            return "0"; // id틀림
        }
    }

    public void updateUser(Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = objMpr.convertValue(userObj, User.class);
        if (session.getAttribute("userId") != null && session.getAttribute("userId").equals(user.getUserId())) {
            user.setPassword(encrypt(user.getPassword()));
            userRepository.save(user);
        }
    }

    public String deleteUser(Map<String, Object> userObj, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result = login(userObj, session);
        if (result.equals("1")||result.equals("0")) {
            return result; // pw틀림
        } else {
            session.removeAttribute("userId");
            userRepository.deleteById((String)userObj.get("userId"));
            return "0"; // 삭제됨
        }
    }

    public String encrypt(String pw) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pw.getBytes("utf-8"));
        return bytesToHex(md.digest());
    }
    public String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b: bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
