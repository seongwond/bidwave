package com.bidwave.controller;

import com.bidwave.dto.ProductDTO;
import com.bidwave.dto.UserDTO;
import com.bidwave.service.ProductService;
import com.bidwave.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import java.security.Principal;

@Controller
public class HomeController {

    private final UserService userService;
    private final ProductService productService;

    public HomeController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
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
                model.addAttribute("user", user);
            }
        } else {
            model.addAttribute("userName", "");
        }

        // 등록된 상품 목록 가져오기
        List<ProductDTO> product = productService.getAllProducts();
        model.addAttribute("product", product);

        // 모든 사용자 정보 가져오기 (추가된 부분)
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "main";
    }
}

