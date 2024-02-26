package com.aiassistant.controller;

import com.aiassistant.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/connectDevice")
    public void connectDevice(@RequestParam("deviceId") String deviceId) {
        demoService.connectDevice(deviceId);
    }

    @PostMapping("/disconnectDevice")
    public void disconnectDevice(@RequestParam("deviceId") String deviceId) {
        demoService.disconnectDevice(deviceId);
    }

    @PostMapping("/sendDeviceMessage")
    public void sendDeviceMessage(@RequestParam("deviceId") String deviceId, @RequestParam("message") String message) {
        demoService.sendDeviceMessage(deviceId, message);
    }

    @PostMapping("/updateDeviceConfig")
    public void updateDeviceConfig(@RequestParam("deviceId") String deviceId, @RequestParam("config") String config) {
        demoService.updateDeviceConfig(deviceId, config);
    }
}
