package com.example.allen.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IdGeneratorUtil {

    public static String generateDealId() {
        return "DEAL_" + UUID.randomUUID();
    }

    public static String generateOrderId() {
        return "ORDER_" + UUID.randomUUID();
    }

    public static String generateLockKey(String userId, String dealId) {
        return userId + "_" + dealId;
    }
}
