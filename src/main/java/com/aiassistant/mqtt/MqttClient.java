package com.aiassistant.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttClient {
    private final String broker;
    private final String clientId;
    private final MqttClient mqttClient;

    public MqttClient(String broker, String clientId) throws MqttException {
        this.broker = broker;
        this.clientId = clientId;
        this.mqttClient = new MqttClient(broker, clientId);
    }

    public void connect() throws MqttException {
        mqttClient.connect();
    }

    public void disconnect() throws MqttException {
        mqttClient.disconnect();
    }

    public void sendMessage(String topic, String message) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttClient.publish(topic, mqttMessage);
    }
}
