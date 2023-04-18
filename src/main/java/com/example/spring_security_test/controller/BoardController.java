package com.example.spring_security_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/board/writeForm")
    public String board() {
        return "board/writeForm";
    }

}
