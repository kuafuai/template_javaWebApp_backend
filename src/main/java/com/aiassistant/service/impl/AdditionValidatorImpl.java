package com.aiassistant.service.impl;

import com.aiassistant.config.AdditionConfig;
import com.aiassistant.service.AdditionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionValidatorImpl implements AdditionValidator {

    private final AdditionConfig additionConfig;

    @Autowired
    public AdditionValidatorImpl(AdditionConfig additionConfig) {
        this.additionConfig = additionConfig;
    }

    @Override
    public boolean validateNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return false;
        }
        if (numbers.size() > additionConfig.getMaxInputNumbers()) {
            return false;
        }
        for (Integer number : numbers) {
            if (number == null || number < 0) {
                return false;
            }
        }
        return true;
    }
}
