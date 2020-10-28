package me.impurity.impuritystackeditemfix;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Map;


public class IllegalUtils {
    public boolean isOverstacked(ItemStack item) {
        return item.getAmount() > item.getMaxStackSize();
    }


    public boolean hasIllegalEnchants(ItemStack item) {
        Map<Enchantment, Integer> enchants = item.getEnchantments();
        for (int level : enchants.values()) {
            return level > 5;
        }
        return false;
    }
}
