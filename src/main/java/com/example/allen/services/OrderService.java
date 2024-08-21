package com.example.allen.services;

import com.example.allen.models.data.Order;
import com.example.allen.models.requests.ClaimDealRequest;

public interface OrderService {

    Order claim(ClaimDealRequest claimDealRequest);

    Order getOrder(String id);
}
