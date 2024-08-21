package com.example.allen.adaptors;

import com.example.allen.models.data.Deal;
import com.example.allen.models.requests.CreateDealRequest;
import com.example.allen.utils.IdGeneratorUtil;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CreateDealRequestToDealAdaptor implements Function<CreateDealRequest, Deal> {

    @Override
    public Deal apply(CreateDealRequest createDealRequest) {
        return Deal.builder()
                .id(IdGeneratorUtil.generateDealId())
                .name(createDealRequest.getName())
                .price(createDealRequest.getPrice())
                .maxLimit(createDealRequest.getMaxLimit())
                .endDate(createDealRequest.getEndDate())
                .build();
    }
}
