/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.repository.impl;

import com.vanthuandev.pojos.Category;
import com.vanthuandev.repository.CategoryRepository;
import java.util.List;
import org.hibernate.Session;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Category");
        List<Category> c = q.getResultList();
        return q.getResultList();
    }

    @Override
    public Category getCategoryById(int cateId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(Category.class, cateId);
    }

}
