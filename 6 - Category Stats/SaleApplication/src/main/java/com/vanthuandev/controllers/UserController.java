package com.vanthuandev.controllers;

import com.vanthuandev.pojos.User;
import com.vanthuandev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
    	return "register";
    }

    @PostMapping("/register")
    public String register(Model model,@ModelAttribute(value = "user") User user) {
        if (user.getPassword().isEmpty()
                || !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errMsg", "Mat khau khong khop!!");
        } else {
            if (this.userService.addUser(user) == true) {
                return "redirect:/login";
            }
            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau");
        }
        return "register";
    }
}
