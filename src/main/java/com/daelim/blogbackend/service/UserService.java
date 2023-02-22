package com.daelim.blogbackend.service;

import com.daelim.blogbackend.entity.User;
import com.daelim.blogbackend.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService{
    ObjectMapper objMpr = new ObjectMapper();
    @Autowired()
    UserRepository userRepository;

    public String signUp(Map<String, Object> userObj, HttpSession session) {
        User user = objMpr.convertValue(userObj, User.class);
        System.out.println(user.toString());
        session.setAttribute("userId", user.getUserId());
        userRepository.save(user);
        return user.getUserId();
    }

    public String login(Map<String, Object> userObj, HttpSession session) {
        String userId = (String) userObj.get("userId");
        String password = (String) userObj.get("password");

        Optional<User> byUserId = userRepository.findByUserId(userId);
        if (byUserId.isPresent()) {
            User user = byUserId.get();
            if (user.getPassword().equals(password)) {
                session.setAttribute("userId", userId);
                return user.getUserId();
            } else {
                return "1"; // id존재 pw틀림
            }
        } else {
            return "0"; // id틀림
        }
    }

    public void updateUser(Map<String, Object> userObj, HttpSession session) {
        User user = objMpr.convertValue(userObj, User.class);
        if (session.getAttribute("userId") != null && session.getAttribute("userId").equals(user.getUserId())) {
            userRepository.save(user);
        }
    }

    public String deleteUser(Map<String, Object> userObj, HttpSession session) {
        String result = login(userObj, session);
        if (result.equals("1")||result.equals("0")) {
            return result; // pw틀림
        } else {
            session.removeAttribute("userId");
            userRepository.deleteById((String)userObj.get("userId"));
            return "0"; // 삭제됨
        }
    }
}
