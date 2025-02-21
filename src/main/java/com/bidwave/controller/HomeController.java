package com.bidwave.controller;

import com.bidwave.dao.TestItemDao;
import com.bidwave.dto.TestItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final TestItemDao testItemDao;

    @Autowired
    public HomeController(TestItemDao testItemDao) {
        this.testItemDao = testItemDao;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<TestItem> items = testItemDao.getAllItems();
        model.addAttribute("items", items);
        return "main";
    }
}
