package me.felek.fenixutilities.Utils;

import me.felek.fenixutilities.configUtility.CustomConfig;
import org.bukkit.entity.Player;

public class PlayerData {
    private static CustomConfig cfg = new CustomConfig();

    private PlayerData(Player player){
        cfg.setup("playerdata/" + player.getName());
    }

    public static PlayerData getPlayerData(Player player) {
        return new PlayerData(player);
    }

    public CustomConfig getConfig() {
        return cfg;
    }
}
