package com.vanthuandev.service.impl;

import com.vanthuandev.pojos.Cart;
import com.vanthuandev.repository.OrderRepository;
import com.vanthuandev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addReceipt(Map<Integer, Cart> cart) {
        if (cart != null)
            return this.orderRepository.addReceipt(cart);
        return false;
    }
}
