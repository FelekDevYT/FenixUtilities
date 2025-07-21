package me.felek.fenixutilities.randomUtils;

import me.felek.fenixutilities.FenixUtilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

//Setting up config settings
public class RtpcfgCommand implements CommandExecutor {
    private final RandomUtility randomUtils;

    public RtpcfgCommand(RandomUtility randomUtils) {
        this.randomUtils = randomUtils;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            switch (args[0]){
                case "world":
                    randomUtils.getConfig().get().set("world", Integer.parseInt(args[1]));
                    break;
                case "minX":
                    randomUtils.getConfig().get().set("minX", Integer.parseInt(args[1]));
                    break;
                case "maxX":
                    randomUtils.getConfig().get().set("maxX", Integer.parseInt(args[1]));
                    break;
                case "minZ":
                    randomUtils.getConfig().get().set("minZ", Integer.parseInt(args[1]));
                    break;
                case "maxZ":
                    randomUtils.getConfig().get().set("maxZ", Integer.parseInt(args[1]));
                    break;
            }
        }

        return true;
    }
}
