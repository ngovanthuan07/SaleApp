/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.service.impl;

import com.vanthuandev.pojos.Comment;
import com.vanthuandev.pojos.Product;
import com.vanthuandev.pojos.User;
import com.vanthuandev.repository.CommentRepository;
import com.vanthuandev.repository.ProductRepository;
import com.vanthuandev.repository.UserRepository;
import com.vanthuandev.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngova
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public Comment addComment(String content, int productId) {
        Product p = this.productRepository.getProductById(productId);
        User u = this.UserRepository.getUserById(6);
        
        Comment c= new Comment();
        c.setContent(content);
        c.setProductId(p);
        c.setUserId(u);
        c.setCreatedDate(new Date());
        
        return this.commentRepository.addComment(c);
    }
    
}
