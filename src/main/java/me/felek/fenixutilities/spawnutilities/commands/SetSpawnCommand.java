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

import java.util.Objects;
import java.util.logging.Level;

public class SetSpawnCommand implements CommandExecutor {
    private final SpawnUtility spawn;

    public SetSpawnCommand(SpawnUtility spawn) {
        this.spawn = spawn;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            Location loc = player.getLocation();
            spawn.getConfig().get().set("location", loc);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', MessageHandler.getStringMessage("spawn.spawn-set")));
        }

        FenixUtilities.getInstance().getLogger().log(Level.FINEST, "Spawn point set");
        return true;
    }
}
