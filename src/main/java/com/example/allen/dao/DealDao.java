package com.example.allen.dao;

import com.example.allen.models.data.Deal;

import java.util.List;

public interface DealDao {

    void insertDeal(Deal deal);

    Deal getDeal(String dealId);

    void updateDeal(Deal deal);

    List<Deal> viewDeals();
}
