package me.felek.fenixutilities.valuteUtils;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.configUtility.CustomConfig;

public class ValueUtility {
    public final CustomConfig cfg = new CustomConfig();
    private final FenixUtilities plug;

    public ValueUtility(FenixUtilities fenix) {
        this.plug = fenix;
        cfg.setup("valute");
    }

    public void deactivate() {
        cfg.save();
    }

    public CustomConfig getConfig() {
        return cfg;
    }

    public void setup(){

    }
}
