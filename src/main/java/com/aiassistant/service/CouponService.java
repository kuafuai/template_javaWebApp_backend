package com.aiassistant.service;

import com.aiassistant.utils.UniqueIdGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponService {

    public List<String> generateCoupons(int number, int length) {
        List<String> coupons = new ArrayList<>();
        UniqueIdGenerator generator = new UniqueIdGenerator();
        for (int i = 0; i < number; i++) {
            String coupon = generator.generateUniqueId(length);
            coupons.add(coupon);
        }
        return coupons;
    }
}
