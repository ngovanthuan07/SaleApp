package com.vanthuandev.controllers;

import com.vanthuandev.pojos.Cart;
import com.vanthuandev.service.OrderService;
import com.vanthuandev.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiCartController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        int productId = params.getProductId();
        if (cart.containsKey(productId)) {// san pham da co trong gio

            Cart c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        } else { // san pham chua co trong gio
            cart.put(productId, params);
        }
        session.setAttribute("cart", cart);

        return Utils.countCart(cart);
    }

    @PutMapping("/api/cart")
    public ResponseEntity<Map<String, String>> updateCartItem(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        int productId = params.getProductId();
        if (cart.containsKey(productId)) {// san pham da co trong gio

            Cart c = cart.get(productId);
            c.setQuantity(params.getQuantity());
        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(
            Utils.cartStats(cart), HttpStatus.OK);
    }
    @DeleteMapping("/api/cart/{productId}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "productId") int productId, HttpSession session){
         Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
         if(cart != null && cart.containsKey(productId)){
             cart.remove(productId);
             session.setAttribute("cart", cart);
         }
         return new ResponseEntity<>(
            Utils.cartStats(cart), HttpStatus.OK);
    }

    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession session) {
        if (this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"))) {
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
