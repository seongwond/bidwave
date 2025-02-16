package com.bidwave.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidController {

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }
}