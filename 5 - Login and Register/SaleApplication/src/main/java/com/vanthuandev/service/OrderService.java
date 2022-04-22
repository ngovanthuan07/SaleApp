package com.vanthuandev.service;

import com.vanthuandev.pojos.Cart;

import java.util.Map;

public interface OrderService {
    boolean addReceipt(Map<Integer, Cart> cart);
}
