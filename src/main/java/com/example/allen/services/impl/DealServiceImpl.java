package com.example.allen.services.impl;

import com.example.allen.adaptors.CreateDealRequestToDealAdaptor;
import com.example.allen.dao.DealDao;
import com.example.allen.models.data.Deal;
import com.example.allen.models.requests.ClaimDealRequest;
import com.example.allen.models.requests.CreateDealRequest;
import com.example.allen.models.requests.EndDealRequest;
import com.example.allen.models.requests.UpdateDealRequest;
import com.example.allen.services.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DealServiceImpl implements DealService {

    private final DealDao dealDao;
    private final CreateDealRequestToDealAdaptor createDealRequestToDealAdaptor;

    @Override
    public Deal createDeal(CreateDealRequest createDealRequest) {
        Deal deal = createDealRequestToDealAdaptor.apply(createDealRequest);
        dealDao.insertDeal(deal);
        return deal;
    }

    @Override
    public Deal updateDeal(UpdateDealRequest updateDealRequest) {
        Deal dbDeal = dealDao.getDeal(updateDealRequest.getId());
        if(Objects.nonNull(updateDealRequest.getMaxLimit())) {
            dbDeal.setMaxLimit(updateDealRequest.getMaxLimit());
        }
        if(Objects.nonNull(updateDealRequest.getEndDate())) {
            dbDeal.setEndDate(updateDealRequest.getEndDate());
        }
        dealDao.updateDeal(dbDeal);
        return dbDeal;
    }

    @Override
    public Deal endDeal(EndDealRequest endDealRequest) {
        Deal dbDeal = dealDao.getDeal(endDealRequest.getId());
        dbDeal.setEndDate(endDealRequest.getEndDate());
        dealDao.updateDeal(dbDeal);
        return dbDeal;
    }

    @Override
    public Deal getDeal(String id) {
        return dealDao.getDeal(id);
    }
}
