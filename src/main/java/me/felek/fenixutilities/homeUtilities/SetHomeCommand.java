package me.felek.fenixutilities.homeUtilities;

import me.felek.fenixutilities.Utils.DimensionUtils;
import me.felek.fenixutilities.Utils.MessageHandler;
import me.felek.fenixutilities.Utils.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SetHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            //sethome home
            String name = args[0];
            int posX = player.getLocation().getBlockX();
            int posY = player.getLocation().getBlockY();
            int posZ = player.getLocation().getBlockZ();
            int world = DimensionUtils.getDimensionNumber(player.getWorld());

            PlayerData pd = PlayerData.getPlayerData(player);
            pd.getConfig();
            List<String> homes = pd.getConfig().get().getStringList("homes");

            for(String home: homes){
                if(home.split(" ")[0].equals(name)) {
                    //If already exists
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', MessageHandler.getStringMessage("home.home-already-exists")));
                    return false;
                }
            }

            /*
            home struct:

            - "<name> <x> <y> <z> <dimension>
             */
            homes.add(name + " " + posX + " " + posY + " " + posZ + " " + world);
            //message by server for player

            player.sendMessage(ChatColor.translateAlternateColorCodes('&', MessageHandler.getStringMessage("home.set-home-success")));

            pd.getConfig().get().set("homes", homes);
            pd.getConfig().save();
            pd.getConfig().reload();
        }

        return true;
    }
}
