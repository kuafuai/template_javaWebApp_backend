package com.aiassistant.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class HelmUtils {
    public static Map<String, Object> parseValueYaml(InputStream inputStream) {
        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }
}
