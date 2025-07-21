package me.felek.fenixutilities.itemUtility;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CustomItemCreator {

    public static ItemStack createCustomItem(ItemStack item, String name, String[] lore, String[] enhancementsMeta, String[] specialAttribsMeta) {
        ItemMeta meta = CustomItemMeta.getCustomItemMetaFromStringList(item.getItemMeta(), AttributeType.ENCHANTMENT, enhancementsMeta);
        meta = CustomItemMeta.getCustomItemMetaFromStringList(meta, AttributeType.SPECIAL_ATTRIBUTE, specialAttribsMeta);

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
}
