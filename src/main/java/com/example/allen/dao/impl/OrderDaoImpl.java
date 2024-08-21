package com.example.allen.dao.impl;

import com.example.allen.dao.OrderDao;
import com.example.allen.datastore.impl.DealDatastore;
import com.example.allen.datastore.impl.OrderDatastore;
import com.example.allen.models.data.Deal;
import com.example.allen.models.data.Order;
import com.example.allen.models.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderDaoImpl implements OrderDao {

    private final OrderDatastore orderDatastore;

    @Override
    public void insertOrder(Order order) {
        orderDatastore.setData(order.getId(), order);
    }

    @Override
    public Order getOrder(String orderId) {
        Order order = orderDatastore.getData(orderId);
        if(Objects.isNull(order)) {
            throw new NotFoundException("Order Doesn't Exist");
        }
        return order;
    }

    @Override
    public Order getOrderUsingUserIdAndDealId(String userId, String dealId) {
        List<Order> orderList = orderDatastore.getList();
        return orderList.stream()
                .filter(order -> userId.equals(order.getUserId()))
                .filter(order -> dealId.equals(order.getDealId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Long getOrderCountUsingDealId(String dealId) {
        List<Order> orderList = orderDatastore.getList();
        return orderList.stream()
                .filter(order -> dealId.equals(order.getDealId()))
                .count();
    }
}
