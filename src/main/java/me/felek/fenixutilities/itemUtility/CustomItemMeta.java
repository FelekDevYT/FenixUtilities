package me.felek.fenixutilities.itemUtility;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.UseCooldownComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CustomItemMeta {

    public static ItemMeta getCustomItemMetaFromStringList(ItemMeta defaultMeta, AttributeType type, String[] list) {
        if (type == AttributeType.ENCHANTMENT) {
            for (String s : list) {
                String[] split = s.split(" ");
                String attributeType = split[0];//Attribute type
                int value = Integer.parseInt(split[1]);//value xd

                defaultMeta.addEnchant(Objects.requireNonNull(Enchantment.getByName(attributeType.toUpperCase())), value, true);
            }
        }else if (type == AttributeType.SPECIAL_ATTRIBUTE) {
            for (String s : list) {
                String[] split = s.split(" ");
                String attributeType = split[0];//Attribute type
                String value = "";
                try{
                    value = split[1];//value xd
                } catch (ArrayIndexOutOfBoundsException e){
                    //without arguments
                    // TODO: delete this, check parameters in methods
                }

                switch (attributeType) {
                    case "rarity":
                        defaultMeta.setRarity(ItemRarity.valueOf(value.toUpperCase()));
                        break;
                    case "unbreaking":
                        defaultMeta.setUnbreakable(true);
                        break;
                }
            }
        }


        return defaultMeta;
    }
}
