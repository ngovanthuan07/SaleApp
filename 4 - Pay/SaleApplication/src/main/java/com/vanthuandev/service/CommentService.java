/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vanthuandev.service;

import com.vanthuandev.pojos.Comment;

/**
 *
 * @author ngova
 */
public interface CommentService {
    Comment addComment(String content, int productId);
}
