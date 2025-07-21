package me.felek.fenixutilities.globalCommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HelpPage {
    private final List<String> helpList = new ArrayList<>();

    public void addLine(String line) {
        helpList.add(line);
    }

    public void print(Player player) {
        for(String line : helpList) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        }
    }
}
