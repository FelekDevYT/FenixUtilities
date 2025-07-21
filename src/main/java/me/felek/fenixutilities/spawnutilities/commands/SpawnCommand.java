package me.felek.fenixutilities.spawnutilities.commands;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.Utils.MessageHandler;
import me.felek.fenixutilities.spawnutilities.SpawnUtility;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class SpawnCommand implements CommandExecutor {
    private final SpawnUtility spawn;

    public SpawnCommand(SpawnUtility spawn) {
        this.spawn = spawn;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            Location loc = spawn.getConfig().get().getLocation("location");
            if(loc != null){
                player.teleport(loc);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MessageHandler.getStringMessage("spawn.spawn-message")));
            }else{
                //you should have it!
            }
        }

        FenixUtilities.getInstance().getLogger().log(Level.INFO, "Player teleported to spawn");
        return true;
    }
}
