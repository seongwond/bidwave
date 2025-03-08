package com.bidwave.controller;

import com.bidwave.dto.BidDTO;
import com.bidwave.dto.UserDTO;
import com.bidwave.service.UserService;
import jakarta.validation.Valid;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDTO userDTO() {
        return new UserDTO();
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

        if (userService.isEmailExists(user.getEmail())) {
            result.rejectValue("email", "error.user", "이미 사용 중인 이메일입니다.");
            return "register";
        }

        userService.registerUser(user);
        return "redirect:/login?registered";
    }

    @GetMapping("/check-email")
    @ResponseBody
    public Map<String, Boolean> checkEmail(@RequestParam String email) {
        boolean exists = userService.isEmailExists(email);
        return Collections.singletonMap("exists", exists);
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
        return "redirect:/main";  // Spring Security 성공한 경우 자동으로 /main 페이지로 이동
    }

    @GetMapping("/mypage")
    public String showMyPage(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        String email = principal.getName();
        UserDTO user = userService.findByEmail(email);
        List<BidDTO> bidList = userService.getBidListByUserEmail(email);

        model.addAttribute("user", user);
        model.addAttribute("bidList", bidList);
        model.addAttribute("userName", user.getName());

        return "mypage";
    }

}
