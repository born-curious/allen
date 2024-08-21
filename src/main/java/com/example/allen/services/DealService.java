package com.example.allen.services;

import com.example.allen.models.data.Deal;
import com.example.allen.models.requests.ClaimDealRequest;
import com.example.allen.models.requests.CreateDealRequest;
import com.example.allen.models.requests.EndDealRequest;
import com.example.allen.models.requests.UpdateDealRequest;

public interface DealService {

    Deal createDeal(CreateDealRequest createDealRequest);

    Deal updateDeal(UpdateDealRequest updateDealRequest);

    Deal endDeal(EndDealRequest endDealRequest);

    Deal getDeal(String id);
}
