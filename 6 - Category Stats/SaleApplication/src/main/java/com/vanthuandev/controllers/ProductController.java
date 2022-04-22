/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanthuandev.controllers;

import com.vanthuandev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ngova
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("/products/{productId}")
    public String detail(Model model,@PathVariable(value= "productId") int productId) {
        model.addAttribute("product", this.productService.getProductById(productId));
        return "product-detail";
    }
}
