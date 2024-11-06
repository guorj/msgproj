package com.vstu.msgproj.process.controller;

import com.vstu.msgproj.process.model.User;
import com.vstu.msgproj.process.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@Controller
@RequestMapping("/api/auth")
public class LoginController {
    Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        System.out.println("login");
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> handleLogin(@RequestBody User user) {
        System.out.println("Received user: " + user); // 记录请求数据
        log.info("Received user: " + user);
        Optional<User> userinfo = userService.getUserByUsername(user.getUsername());

        if (userinfo.isPresent() && userinfo.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
//        // 创建身份验证请求
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//        );
//        // 如果身份验证成功，则设置上下文
//        if (authentication.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return "redirect:/success"; // 登录成功后重定向
//        } else {
//            return "redirect:/login?error"; // 登录失败重定向
//        }
    }



    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(String username, String password, String role, Model model) {
        // 在注册新用户前检查用户名是否已被使用
        if (!userService.isUsernameTaken(username)) {
            userService.registerUser(username, password, role);
            return "redirect:/login"; // 注册成功后重定向到登录页面
        } else {
            // 处理用户名重复的情况
            model.addAttribute("error", "Username already taken.");
            return "register";
        }
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}