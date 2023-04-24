package com.example.spring_security_test.controller;

import com.example.spring_security_test.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/auth/loginErrorForm")
    public String loginErrorForm() {
        return "user/loginErrorForm";
    }

    @GetMapping("/user/userForm")
    public String userForm(Model model,
                           @AuthenticationPrincipal PrincipalDetail principal) {
        model.addAttribute("principal", principal);
        return "user/userForm";
    }

    @GetMapping("/user/updateForm")
    public String userUpdateForm(Model model,
                           @AuthenticationPrincipal PrincipalDetail principal) {
        model.addAttribute("principal", principal);
        return "user/userUpdateForm";
    }

}
