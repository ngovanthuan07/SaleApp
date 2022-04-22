package com.vanthuandev.repository;

import com.vanthuandev.pojos.Cart;

import java.util.Map;

public interface OrderRepository {
    boolean addReceipt(Map<Integer, Cart> cart );
}
