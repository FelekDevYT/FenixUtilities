package me.felek.fenixutilities.globalCommands;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.configUtility.CustomConfig;

import java.util.List;

public class GlobalUtility {
    public final HelpPage helpPage;
    public final CustomConfig cfg = new CustomConfig();

    public GlobalUtility(HelpPage helpPage) {
        this.helpPage = helpPage;
    }

    public void setup(){
        cfg.setup("global");

        List<String> lines = cfg.get().getStringList("help");
        for(String line : lines){
            helpPage.addLine(line);
        }

        FenixUtilities.getInstance().getCommand("help").setExecutor(new HelpCommand(this));
    }

    public void deactivate(){
        cfg.save();
    }
}
