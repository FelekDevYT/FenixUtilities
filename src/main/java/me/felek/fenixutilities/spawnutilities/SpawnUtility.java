package me.felek.fenixutilities.spawnutilities;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.configUtility.CustomConfig;
import me.felek.fenixutilities.spawnutilities.commands.SetSpawnCommand;
import me.felek.fenixutilities.spawnutilities.commands.SpawnCommand;
import me.felek.fenixutilities.spawnutilities.commands.SpawncfgCommand;

public class SpawnUtility {
    public final CustomConfig cfg = new CustomConfig();

    public void setup(){
        setupConfig();
        setupCommands();
    }

    public void deactivate(){
        cfg.save();
    }

    public CustomConfig getConfig() {
        return cfg;
    }

    public void setupConfig(){
        cfg.setup("spawn");
    }

    public void setupCommands(){
        FenixUtilities.getInstance().getCommand("spawn").setExecutor(new SpawnCommand(this));
        FenixUtilities.getInstance().getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        FenixUtilities.getInstance().getCommand("spawncfg").setExecutor(new SpawncfgCommand(this));
    }
}
