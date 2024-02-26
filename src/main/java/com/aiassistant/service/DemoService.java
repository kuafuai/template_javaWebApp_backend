package com.aiassistant.service;

import com.aiassistant.mapper.DeviceMapper;
import com.aiassistant.mqtt.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final DeviceMapper deviceMapper;
    private final MqttClient mqttClient;

    @Autowired
    public DemoService(DeviceMapper deviceMapper, MqttClient mqttClient) {
        this.deviceMapper = deviceMapper;
        this.mqttClient = mqttClient;
    }

    public void connectDevice(String deviceId) {
        deviceMapper.updateDeviceStatus(deviceId, "online");
    }

    public void disconnectDevice(String deviceId) {
        deviceMapper.updateDeviceStatus(deviceId, "offline");
    }

    public void sendDeviceMessage(String deviceId, String message) {
        mqttClient.sendMessage(deviceId, message);
    }

    public void updateDeviceConfig(String deviceId, String config) {
        deviceMapper.updateDeviceConfig(deviceId, config);
    }
}
