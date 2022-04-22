/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vanthuandev.repository;

import com.vanthuandev.pojos.Product;
import java.util.List;

/**
 *
 * @author ngova
 */
public interface ProductRepository {
    List<Product> getProducts(String kw, int page);
    List<Object[]> getHotProducts(int num);
    List<Object[]> getMostDiscussProducts(int num);
    Product getProductById(int productId);
    long countProduct();
    boolean addOrUpdate(Product product);
}
