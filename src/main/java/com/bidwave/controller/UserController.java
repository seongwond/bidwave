package com.bidwave.controller;

import com.bidwave.dto.UserDTO;
import com.bidwave.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.registerUser(user);
        return "redirect:/login?registered";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        return "redirect:/main";  // Spring Security가 성공한 경우 자동으로 /main 페이지로 이동
    }

}
