/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vanthuandev.service;

import com.vanthuandev.pojos.Product;
import java.util.List;

/**
 *
 * @author ngova
 */
public interface ProductService {

    List<Product> getProducts(String kw, int page);

    List<Object[]> getHotProducts(int num);

    List<Object[]> getMostDiscussProducts(int num);

    long countProduct();

    boolean addOrUpdate(Product product);

    Product getProductById(int productId);

}
