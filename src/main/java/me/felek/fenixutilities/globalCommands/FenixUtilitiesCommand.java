package me.felek.fenixutilities.globalCommands;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.Utils.MessageHandler;
import me.felek.fenixutilities.Utils.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FenixUtilitiesCommand implements CommandExecutor {
    private final FenixUtilities plug;

    public FenixUtilitiesCommand(FenixUtilities plug) {
        this.plug = plug;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        switch (args[0]) {
            case "reload":
//                plug.randomUtility.cfg.save();
//                plug.spawnUtility.cfg.save();
//                plug.globalUtility.cfg.save();
//                plug.homeUtilities.cfg.save();
//                MessageHandler.getConfig().save();

                plug.randomUtility.getConfig().reload();
                plug.spawnUtility.getConfig().reload();
                plug.homeUtilities.cfg.reload();
                plug.globalUtility.cfg.reload();
                MessageHandler.getConfig().reload();

                for(Player player : Bukkit.getOnlinePlayers()) {
                    PlayerData pd = PlayerData.getPlayerData(player);
                    pd.getConfig().reload();
                }

                plug.getLogger().info("Reloaded config");
                sender.sendMessage("Reloaded config");
                break;
        }

        return true;
    }
}
