package me.felek.fenixutilities.randomUtils;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.configUtility.CustomConfig;

public class RandomUtility {
    public final CustomConfig cfg = new CustomConfig();

    public RandomUtility() {
        cfg.setup("rtps");
    }

    public void deactivate(){
        cfg.save();
    }

    public CustomConfig getConfig() {
        return cfg;
    }

    public void setup(){
        FenixUtilities.getInstance().getCommand("rtp").setExecutor(new RtpCommand(cfg));
        FenixUtilities.getInstance().getCommand("rtpcfg").setExecutor(new RtpcfgCommand(this));
    }


}
