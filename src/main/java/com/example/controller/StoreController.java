package com.example.controller;

import com.example.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @PostMapping("/store")
    public ResponseEntity<?> createStore(@RequestBody Store store) {
        // TODO: Implement the logic to create a store
        return ResponseEntity.ok().build();
    }
}
