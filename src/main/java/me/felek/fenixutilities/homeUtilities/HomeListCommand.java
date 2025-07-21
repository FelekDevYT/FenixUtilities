package me.felek.fenixutilities.homeUtilities;

import me.felek.fenixutilities.Utils.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeListCommand implements CommandExecutor {
    private final HomeUtilities helper;

    public HomeListCommand(HomeUtilities helper) {
        this.helper = helper;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            PlayerData pd = PlayerData.getPlayerData(player);
            pd.getConfig();
            List<String> homes = pd.getConfig().get().getStringList("homes");

            //It should be looks like this:
            //<homeName>: <dimention> <posX> <posY> <posZ>
            for (String home : homes) {
                String[] line = home.split(" ");
                StringBuilder sb = new StringBuilder();

                sb.append(line[0]);
                sb.append(": ");
                final String word = line[line.length - 1];
                if(word.equals("0")){
                    sb.append("overworld");
                }else if(word.equals("1")) {
                    sb.append("nether");
                }else if(word.equals("2")) {
                    sb.append("the end");
                }

                sb.append(" ");
                sb.append(line[1]);
                sb.append(" ");
                sb.append(line[2]);
                sb.append(" ");
                sb.append(line[3]);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', sb.toString()));
            }
        }

        return true;
    }
}
