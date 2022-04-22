package com.vanthuandev.repository.impl;

import com.vanthuandev.pojos.Cart;
import com.vanthuandev.pojos.OrderDetail;
import com.vanthuandev.pojos.SaleOrder;
import com.vanthuandev.repository.OrderRepository;
import com.vanthuandev.repository.ProductRepository;
import com.vanthuandev.repository.UserRepository;
import com.vanthuandev.utils.Utils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Repository
public class OderRepositoryImpl implements OrderRepository {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // có nhiều giao tác và có quan hệ cha con
    public boolean addReceipt(Map<Integer, Cart> cart) {
        try
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            SaleOrder order = new SaleOrder();
            order.setUserId(this.userRepository.getUserById(6));
            order.setCreatedDate(new Date());

            Map<String, String> stats = Utils.cartStats(cart);
            order.setAmount(Long.parseLong(stats.get("amount")));

            session.save(order);

            for(Cart c : cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setOrderId(order);
                d.setProductId(this.productRepository.getProductById(c.getProductId()));
                d.setUnitPrice(c.getPrice());
                d.setNum(c.getQuantity());
                session.save(d);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
