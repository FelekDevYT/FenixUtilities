package me.felek.fenixutilities.homeUtilities;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.Utils.MessageHandler;
import me.felek.fenixutilities.Utils.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeCommand implements CommandExecutor {
    private final FenixUtilities plug = FenixUtilities.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            /*
            home struct:

            - "<name> <x> <y> <z> <dimension>
             */
            PlayerData dt = PlayerData.getPlayerData(player);
            List<String> homes = dt.getConfig().get().getStringList("homes");
            for(String home : homes){
                String[] line = home.split(" ");

                if(line[0].equals(args[0])){
                    player.teleport(new Location((World)plug.getServer().getWorlds().get(this.plug.getConfig().getInt("world")),
                            Integer.parseInt(line[1]),
                            Integer.parseInt(line[2]),
                            Integer.parseInt(line[3])));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', MessageHandler.getStringMessage("home.teleport-success")));

                    return true;
                }
            }

            player.sendMessage(ChatColor.translateAlternateColorCodes('&', MessageHandler.getStringMessage("home.home-doesnt-exists")));
        }

        return true;
    }
}
