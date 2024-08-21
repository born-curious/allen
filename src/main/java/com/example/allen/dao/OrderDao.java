package com.example.allen.dao;

import com.example.allen.models.data.Order;

import java.util.List;

public interface OrderDao {

    void insertOrder(Order order);

    Order getOrder(String orderId);

    Order getOrderUsingUserIdAndDealId(String userId, String dealId);

    Long getOrderCountUsingDealId(String dealId);
}
