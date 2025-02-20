package com.bidwave.controller;

import com.bidwave.dto.AuctionDTO;
import com.bidwave.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<AuctionDTO> featuredAuctions = homeService.getFeaturedAuctions();
        model.addAttribute("featuredAuctions", featuredAuctions);
        return "main";
    }
}
