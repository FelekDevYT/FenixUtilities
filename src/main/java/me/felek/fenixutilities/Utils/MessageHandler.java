package me.felek.fenixutilities.Utils;

import me.felek.fenixutilities.configUtility.CustomConfig;

public class MessageHandler {
    public static CustomConfig cfg = new CustomConfig();



    public static void deactivate(){
        cfg.save();
    }

    public static CustomConfig getConfig() {
        return cfg;
    }

    public static void setupConfig(){
        cfg.setup("messages");
    }

    public static String getStringMessage(String path) {
        return cfg.get().getString(path);
    }
}
