package me.felek.fenixutilities.configUtility;

import java.util.HashMap;
import java.util.Map;

public class Configs {
    private static final Map<String, CustomConfig> configs = new HashMap<>();

    public static CustomConfig getConfig(final String name) {
        return configs.get(name);
    }

    public static void addConfig(final String name, final CustomConfig config) {
        configs.put(name, config);
    }

    public static Map<String, CustomConfig> getConfigs() {
        return configs;
    }
}
