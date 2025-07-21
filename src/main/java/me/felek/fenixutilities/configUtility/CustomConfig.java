package me.felek.fenixutilities.configUtility;

import me.felek.fenixutilities.FenixUtilities;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomConfig {

    private File file;
    private FileConfiguration customFile;

    //Finds or generates the custom config file
    public void setup(String cfgname){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("fenixutilities").getDataFolder(), cfgname + ".yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                FenixUtilities.getInstance().getLogger().log(Level.SEVERE, "Could not create file " + file.getAbsolutePath(), e);
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get(){
        return customFile;
    }

    public void save(){
        try{
            customFile.save(file);
        }catch (IOException e){
            FenixUtilities.getInstance().getLogger().log(Level.CONFIG, "Couldn't save file");
        }
    }

    public void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
