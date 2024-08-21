package com.example.allen.utils;

import com.example.allen.models.data.Deal;
import com.example.allen.models.exceptions.ValidationException;
import com.example.allen.models.requests.ClaimDealRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidityUtil {

    public static void validateClaimRequest(Long orderCount, Deal deal) {
        Date now = new Date();
        if(deal.getEndDate().before(now)) {
            throw new ValidationException("Deal has been expired");
        }
        if(Objects.nonNull(orderCount) && deal.getMaxLimit() <= orderCount) {
            throw new ValidationException("Deal has been exhausted");
        }
    }
}
