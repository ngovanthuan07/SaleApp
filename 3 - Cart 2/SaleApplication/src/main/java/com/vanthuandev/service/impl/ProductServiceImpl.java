/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.service.impl;

import com.cloudinary.Cloudinary;
import com.vanthuandev.pojos.Product;
import com.vanthuandev.repository.ProductRepository;
import com.vanthuandev.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngova
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productRepository.getProducts(kw, page);
    }

    @Override
    public boolean addOrUpdate(Product product) {
//        try {
//            Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            product.setImage((String) r.get("secure_url"));
//            return this.productRepository.addOrUpdate(product);
//        } catch (IOException ex) {
//            System.err.println("== ADD PRODUCT ==" + ex.getMessage());
//        }
        return false;
    }

    @Override
    public long countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }

    @Override
    public List<Object[]> getHotProducts(int num) {
        return this.productRepository.getHotProducts(num);
    }

    @Override
    public List<Object[]> getMostDiscussProducts(int num) {
        return this.productRepository.getMostDiscussProducts(num);
    }

}
