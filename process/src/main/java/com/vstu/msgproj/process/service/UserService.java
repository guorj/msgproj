package com.vstu.msgproj.process.service;//package com.vstu.msgProject.service;

import com.vstu.msgproj.process.model.User;
import com.vstu.msgproj.process.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository/*, BCryptPasswordEncoder passwordEncodery*/) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.existsByUsername(username);
    }

    public void registerUser(String username, String password, String role) {
        // 加密密码
//        String encodedPassword = passwordEncoder.encode(password);

        // 创建用户对象
        User newUser = new User();
        newUser.setUsername(username);
//        newUser.setPassword(encodedPassword);
        newUser.setPassword(password);
        newUser.setRole(role);


        // 存储用户信息
        userRepository.save(newUser);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}