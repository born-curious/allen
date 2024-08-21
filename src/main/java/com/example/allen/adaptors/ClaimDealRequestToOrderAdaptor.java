package com.example.allen.adaptors;

import com.example.allen.models.data.Deal;
import com.example.allen.models.data.Order;
import com.example.allen.models.requests.ClaimDealRequest;
import com.example.allen.models.requests.CreateDealRequest;
import com.example.allen.utils.IdGeneratorUtil;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClaimDealRequestToOrderAdaptor implements Function<ClaimDealRequest, Order> {

    @Override
    public Order apply(ClaimDealRequest claimDealRequest) {
        return Order.builder()
                .id(IdGeneratorUtil.generateOrderId())
                .dealId(claimDealRequest.getDealId())
                .userId(claimDealRequest.getUserId())
                .build();
    }
}
