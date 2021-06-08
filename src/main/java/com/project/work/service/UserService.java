package com.project.work.service;

import com.project.work.model.User;
import com.project.work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public void saveUser(User user) {
        if (user != null) {
            user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    public String activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null) {
            return "noresult";
        }
        user.setActive(true);
        user.setActivationCode("");
        userRepository.save(user);
        return "ok";
    }

    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
