package com.vanthuandev.service;

import com.vanthuandev.pojos.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategoryById(int cateId);
}
