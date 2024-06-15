package com.aiassistant.utils;

import java.util.UUID;

public class UniqueIdGenerator {
    public static String generateUniqueId(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero");
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        if (uuid.length() < length) {
            throw new IllegalArgumentException("Length is greater than the length of generated UUID");
        }

        return uuid.substring(0, length);
    }
}
