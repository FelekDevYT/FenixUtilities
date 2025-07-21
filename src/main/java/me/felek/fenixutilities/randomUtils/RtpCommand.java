package me.felek.fenixutilities.randomUtils;

import me.felek.fenixutilities.FenixUtilities;
import me.felek.fenixutilities.Utils.MessageHandler;
import me.felek.fenixutilities.Utils.PlayerUtils;
import me.felek.fenixutilities.configUtility.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class RtpCommand implements CommandExecutor {
    private final CustomConfig cfg;
    private final FenixUtilities plugin = FenixUtilities.getInstance();

    public RtpCommand(CustomConfig cfg) {
        this.cfg = cfg;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            int minX = cfg.get().getInt("minX");
            int maxX = cfg.get().getInt("maxX");
            int minZ = cfg.get().getInt("minZ");
            int maxZ = cfg.get().getInt("maxZ");

            List<Integer> cords = new ArrayList<>();
            cords.add(minX);
            cords.add(maxX);
            cords.add(minZ);
            cords.add(maxZ);

            List<Integer> c = PlayerUtils.RandomTeleportationPlayer(player, (World)plugin.getServer().getWorlds().get(this.plugin.getConfig().getInt("world")), (Integer)cords.get(0), (Integer)cords.get(1), (Integer)cords.get(2), (Integer)cords.get(3));
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_TELEPORT, 1.0f, 0.0f);
            try {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format(MessageHandler.getStringMessage("rtp.rtp-success"), c.get(0), c.get(1), c.get(2))));
            }catch (Exception e){
                FenixUtilities.getInstance().getLogger().log(Level.CONFIG, "Structure of rtp.rtp should be ...%d...%d...%d... -->> read documentation for resolve problem.");
                player.sendMessage(ChatColor.GREEN + "You teleported to : " + c.get(0) + "," + c.get(1) + "," + c.get(2));
            }
        }

        return true;
    }


}
