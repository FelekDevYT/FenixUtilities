package me.felek.fenixutilities.itemUtility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/*
Item structure in yml:
items:
    superItem:
        defaultItem: DIAMOND_PICKAXE
        name: Emerald pickaxe
        lore:
            - coolest pickaxe in the world.
            - made by Felek :)
        attributes:
            durability: 5000
            efficiency:
 */
public class GetCustomItemCommand implements CommandExecutor {
    private final CustomItemUtility customItemMeta;

    public GetCustomItemCommand(CustomItemUtility customItemMeta) {
        this.customItemMeta = customItemMeta;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String name = args[0];

            Material defaultItem = Material.getMaterial(Objects.requireNonNull(customItemMeta.getConfig().get().getString("items." + name + ".defaultItem")));
            String userName = Objects.requireNonNull(customItemMeta.getConfig().get().getString("items." + name + ".name"));

            List<String> enchantmentsAttributes = customItemMeta.getConfig().get().getStringList("items." + name + ".enchantments");
            List<String> specialAttributes = customItemMeta.getConfig().get().getStringList("items." + name + ".attribs");

            List<String> lore = customItemMeta.getConfig().get().getStringList("items." + name + ".lore");

            player.getInventory().addItem(CustomItemCreator.createCustomItem(ItemStack.of(defaultItem), ChatColor.translateAlternateColorCodes('&', userName), toStringArray(lore),  toStringArray(enchantmentsAttributes), toStringArray(specialAttributes)));
        }

        return true;
    }

    public String[] toStringArray(List<String> list) {
        String[] array = new String[list.size()];
        return list.toArray(array);
    }
}
