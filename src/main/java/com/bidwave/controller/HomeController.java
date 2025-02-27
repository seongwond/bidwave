package com.bidwave.controller;

import com.bidwave.dto.UserDTO;
import com.bidwave.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model, Principal principal) {
        if (principal != null) {
            UserDTO user = userService.findByEmail(principal.getName());
            if (user != null) {
                model.addAttribute("userName", user.getName());
            }
        } else {
            model.addAttribute("userName", "");
        }
        return "main";
    }
}

