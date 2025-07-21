package me.felek.fenixutilities.homeUtilities;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.configUtility.CustomConfig;

public class HomeUtilities {

    public void setup(){
        FenixUtilities.getInstance().getCommand("home").setExecutor(new HomeCommand());
        FenixUtilities.getInstance().getCommand("sethome").setExecutor(new SetHomeCommand());
        FenixUtilities.getInstance().getCommand("homelist").setExecutor(new HomeListCommand(this));
    }

    public void deactivate(){
    }
}
