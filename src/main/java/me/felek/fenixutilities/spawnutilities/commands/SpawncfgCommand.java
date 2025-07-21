package me.felek.fenixutilities.spawnutilities.commands;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.spawnutilities.SpawnUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SpawncfgCommand implements CommandExecutor {
    private final SpawnUtility spawnutils;

    public SpawncfgCommand(SpawnUtility spawnutils) {
        this.spawnutils = spawnutils;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        switch (args[0]) {
            case "setSpawnMessage":
                StringBuilder cmd = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    cmd.append(args[i]).append(" ");
                }

                spawnutils.cfg.get().set("spawn-message", cmd.toString());
                break;
            case "setSetSpawnMessage":
                cmd = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    cmd.append(args[i]).append(" ");
                }

                spawnutils.cfg.get().set("spawn-set", cmd.toString());

                break;
        }

        return true;
    }
}
