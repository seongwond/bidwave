package com.bidwave.controller;

import com.bidwave.dto.ProductDTO;
import com.bidwave.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 물품 컨트롤러.
 */
@Controller
@RequestMapping("/register-item")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showRegisterProductForm(Model model) { // 물품 등록 폼 표시
        model.addAttribute("item", new ProductDTO());
        return "register-item";
    }

    @PostMapping
    public String registerProduct(@RequestParam("description") String description, ProductDTO item) {
        item.setDescription(description);
        productService.addProduct(item);
        return "redirect:/main";
    }
}
