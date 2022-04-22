package com.vanthuandev.repository;

import com.vanthuandev.pojos.Category;
import java.util.List;

public interface CategoryRepository {
    List<Category> getCategories();
    Category getCategoryById(int cateId);
}
