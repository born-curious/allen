package com.example.allen.dao.impl;

import com.example.allen.dao.DealDao;
import com.example.allen.datastore.impl.DealDatastore;
import com.example.allen.models.data.Deal;
import com.example.allen.models.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DealDaoImpl implements DealDao {

    private final DealDatastore dealDatastore;

    @Override
    public void insertDeal(Deal deal) {
        dealDatastore.setData(deal.getId(), deal);
    }

    @Override
    public Deal getDeal(String dealId) {
        Deal deal = dealDatastore.getData(dealId);
        if(Objects.isNull(deal)) {
            throw new NotFoundException("Deal Doesn't Exist");
        }
        return deal;
    }

    @Override
    public void updateDeal(Deal deal) {
        dealDatastore.setData(deal.getId(), deal);
    }

    @Override
    public List<Deal> viewDeals() {
        return dealDatastore.getList();
    }
}
