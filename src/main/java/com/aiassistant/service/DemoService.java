package com.aiassistant.service;

import java.util.List;

public interface DemoService {
    List<String> generateEmojis(String text, int numEmojis);
}
