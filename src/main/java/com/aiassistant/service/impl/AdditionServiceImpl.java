package com.aiassistant.service.impl;

import com.aiassistant.service.AdditionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionServiceImpl implements AdditionService {

    @Override
    public int addNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    public int subtractNumbers(List<Integer> numbers) {
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        return result;
    }
}
