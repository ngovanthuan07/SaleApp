package com.vanthuandev.service.impl;

import com.vanthuandev.pojos.Category;
import com.vanthuandev.repository.CategoryRepository;
import com.vanthuandev.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(int cateId) {
        return this.categoryRepository.getCategoryById(cateId);
    }
    
}
