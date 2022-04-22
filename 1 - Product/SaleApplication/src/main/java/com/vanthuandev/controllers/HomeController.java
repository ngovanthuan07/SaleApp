package com.vanthuandev.controllers;

import com.vanthuandev.pojos.Category;
import com.vanthuandev.pojos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.vanthuandev.service.CategoryService;	
import com.vanthuandev.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
	private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void commonAttrs(Model model){
      model.addAttribute("categories", this.categoryService.getCategories());
    }
    
    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", " ");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        String cateId = params.get("cateId");
        if(cateId == null){
            model.addAttribute("products", this.productService.getProducts(kw, page));
        } else {
            Category c = this.categoryService.getCategoryById(Integer.parseInt(cateId));
            model.addAttribute("products", c.getProductCollection());
        }
        Product p = this.productService.getProductById(2);
        model.addAttribute("productCounter", this.productService.countProduct());        
        model.addAttribute("hotProducts", this.productService.getHotProducts(6));
        List<Object[]> object = this.productService.getMostDiscussProducts(6);
        model.addAttribute("disProducts", this.productService.getMostDiscussProducts(6));
        return "index";
    }
}
