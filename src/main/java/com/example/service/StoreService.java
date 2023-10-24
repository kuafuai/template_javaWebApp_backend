package com.example.service;

import com.example.mapper.StoreMapper;
import com.example.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    private final StoreMapper storeMapper;

    @Autowired
    public StoreService(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    public void createStore(Store store) {
        validateStore(store);
        try {
            storeMapper.insertStore(store);
        } catch (Exception e) {
            // Handle the exception here, e.g. log the error or throw a custom exception
            e.printStackTrace();
        }
    }

    private void validateStore(Store store) {
        // Perform input validation here, e.g. check if required fields are present and have valid values
        if (store.getName() == null || store.getName().isEmpty()) {
            throw new IllegalArgumentException("Store name is required");
        }
        // Add more validation logic as needed
    }
}
