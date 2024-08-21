package com.example.allen.services.impl;

import com.example.allen.adaptors.ClaimDealRequestToOrderAdaptor;
import com.example.allen.dao.LockDao;
import com.example.allen.dao.OrderDao;
import com.example.allen.models.data.Deal;
import com.example.allen.models.data.Lock;
import com.example.allen.models.data.Order;
import com.example.allen.models.exceptions.AlreadyExistsException;
import com.example.allen.models.exceptions.ValidationException;
import com.example.allen.models.requests.ClaimDealRequest;
import com.example.allen.services.DealService;
import com.example.allen.services.OrderService;
import com.example.allen.utils.IdGeneratorUtil;
import com.example.allen.utils.ValidityUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final LockDao lockDao;
    private final DealService dealService;
    private final ClaimDealRequestToOrderAdaptor claimDealRequestToOrderAdaptor;

    @Override
    public Order claim(ClaimDealRequest claimDealRequest) {
        String lockKey = IdGeneratorUtil.generateLockKey(claimDealRequest.getUserId(), claimDealRequest.getDealId());
        if(lockDao.exists(lockKey)) {
            throw new AlreadyExistsException("Another Claim in progress!!!");
        }
        Lock lock = new Lock(lockKey, DateUtils.addMinutes(new Date(), 1));
        lockDao.acquire(lock);
        Deal deal = dealService.getDeal(claimDealRequest.getDealId());
        Long count = orderDao.getOrderCountUsingDealId(claimDealRequest.getDealId());
        ValidityUtil.validateClaimRequest(count, deal);
        Order dbOrder = orderDao.getOrderUsingUserIdAndDealId(claimDealRequest.getUserId(),
                claimDealRequest.getDealId());
        if (Objects.nonNull(dbOrder)) {
            throw new ValidationException("Max Limit Reached for the User for this deal");
        }
        Order order = claimDealRequestToOrderAdaptor.apply(claimDealRequest);
        orderDao.insertOrder(order);
        lockDao.release(lock);
        return order;
    }

    @Override
    public Order getOrder(String id) {
        return orderDao.getOrder(id);
    }
}
