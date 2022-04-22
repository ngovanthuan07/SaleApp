package com.vanthuandev.controllers;

import com.vanthuandev.pojos.Cart;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        Map<Integer, Cart> cart =  (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null){
            model.addAttribute("carts", cart.values());
        } else {
            model.addAttribute("carts", null);
        }
        return "cart";
    }
}
