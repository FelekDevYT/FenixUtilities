package me.felek.fenixutilities.itemUtility;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.configUtility.CustomConfig;

public class CustomItemUtility {
    public final CustomConfig cfg = new CustomConfig();

    public void setup() {
        setupCommands();
        setupConfig();
    }

    public void setupConfig() {
        cfg.setup("customItem");
    }

    public void setupCommands() {
        FenixUtilities.getInstance().getCommand("get").setExecutor(new GetCustomItemCommand(this));
    }

    public CustomConfig getConfig() {
        return cfg;
    }

    public void deactivate() {
        cfg.save();
    }
}
