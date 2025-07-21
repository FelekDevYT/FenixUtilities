package me.felek.fenixutilities;

import me.felek.fenixutilities.Utils.MessageHandler;
import me.felek.fenixutilities.globalCommands.FenixUtilitiesCommand;
import me.felek.fenixutilities.globalCommands.GlobalUtility;
import me.felek.fenixutilities.globalCommands.HelpPage;
import me.felek.fenixutilities.homeUtilities.HomeUtilities;
import me.felek.fenixutilities.itemUtility.CustomItemUtility;
import me.felek.fenixutilities.randomUtils.RandomUtility;
import me.felek.fenixutilities.spawnutilities.SpawnUtility;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Level;

public final class FenixUtilities extends JavaPlugin {

    private static FenixUtilities instance;

    public SpawnUtility spawnUtility;
    public RandomUtility randomUtility;
    public GlobalUtility globalUtility;
    public HomeUtilities homeUtilities;
    public CustomItemUtility customItemUtility;

    public static FenixUtilities getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        //Making directories
        new File(Paths.get(this.getDataFolder() + "/playerdata").toUri()).mkdirs();

        //Initializing
        spawnUtility = new SpawnUtility();
        randomUtility = new RandomUtility();
        globalUtility = new GlobalUtility( new HelpPage());
        homeUtilities = new HomeUtilities();
        customItemUtility = new CustomItemUtility();
        MessageHandler.setupConfig();

        //Enabling utilities
        spawnUtility.setup();
        randomUtility.setup();
        globalUtility.setup();
        homeUtilities.setup();
        customItemUtility.setup();

        //Globals
        getCommand("fu").setExecutor(new FenixUtilitiesCommand(this));

        getLogger().log(Level.INFO, "Fenix utilities has been enabled");
    }

    @Override
    public void onDisable() {
        //saving configs
        spawnUtility.deactivate();
        randomUtility.deactivate();
        globalUtility.deactivate();
        homeUtilities.deactivate();
        customItemUtility.deactivate();
        MessageHandler.deactivate();

        getLogger().log(Level.INFO, "Fenix utilities has been disabled");
    }
}
