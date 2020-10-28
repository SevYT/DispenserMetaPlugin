package me.impurity.impuritystackeditemfix;

import org.bukkit.block.ShulkerBox;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.util.Map;

public class Listeners implements Listener {
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        for (ItemStack item : event.getInventory().getContents()) {
            if (item != null) {
                if (ImpurityStackedItemFix.getPlugin().illegalUtils.isOverstacked(item)) {
                    item.setAmount(item.getMaxStackSize());
                }
                if (ImpurityStackedItemFix.getPlugin().illegalUtils.hasIllegalEnchants(item)) {
                    for (Map.Entry<Enchantment, Integer> enchantmentIntegerEntry : item.getEnchantments().entrySet()) {
                        if (enchantmentIntegerEntry.getKey().canEnchantItem(item)) {
                            item.addEnchantment(enchantmentIntegerEntry.getKey(), enchantmentIntegerEntry.getKey().getMaxLevel());
                        } else {
                            item.removeEnchantment(enchantmentIntegerEntry.getKey());
                        }
                    }
                }
            }
        }
        Player nigger = (Player) event.getPlayer();
        for (ItemStack item : nigger.getInventory().getContents()) {
            if (item != null) {
                if (ImpurityStackedItemFix.getPlugin().illegalUtils.isOverstacked(item)) {
                    item.setAmount(item.getMaxStackSize());
                }
                if (ImpurityStackedItemFix.getPlugin().illegalUtils.hasIllegalEnchants(item)) {
                    for (Map.Entry<Enchantment, Integer> enchantmentIntegerEntry : item.getEnchantments().entrySet()) {
                        if (enchantmentIntegerEntry.getKey().canEnchantItem(item)) {
                            item.addEnchantment(enchantmentIntegerEntry.getKey(), enchantmentIntegerEntry.getKey().getMaxLevel());
                        } else {
                            item.removeEnchantment(enchantmentIntegerEntry.getKey());
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        for (ItemStack item : event.getInventory().getContents()) {
            if (item != null) {
                if (ImpurityStackedItemFix.getPlugin().illegalUtils.isOverstacked(item)) {
                    item.setAmount(item.getMaxStackSize());
                }
                if (ImpurityStackedItemFix.getPlugin().illegalUtils.hasIllegalEnchants(item)) {
                    for (Map.Entry<Enchantment, Integer> enchantmentIntegerEntry : item.getEnchantments().entrySet()) {
                        if (enchantmentIntegerEntry.getKey().canEnchantItem(item)) {
                            item.addEnchantment(enchantmentIntegerEntry.getKey(), enchantmentIntegerEntry.getKey().getMaxLevel());
                        } else {
                            item.removeEnchantment(enchantmentIntegerEntry.getKey());
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        ItemStack item = event.getItem().getItemStack();
        if (item != null) {
            if (ImpurityStackedItemFix.getPlugin().illegalUtils.isOverstacked(item)) {
                item.setAmount(item.getMaxStackSize());
            }
            if (ImpurityStackedItemFix.getPlugin().illegalUtils.hasIllegalEnchants(item)) {
                for (Map.Entry<Enchantment, Integer> enchantmentIntegerEntry : item.getEnchantments().entrySet()) {
                    if (enchantmentIntegerEntry.getKey().canEnchantItem(item)) {
                        item.addEnchantment(enchantmentIntegerEntry.getKey(), enchantmentIntegerEntry.getKey().getMaxLevel());
                    } else {
                        item.removeEnchantment(enchantmentIntegerEntry.getKey());
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        ItemStack itemStack = event.getItemInHand();
        if (itemStack.getItemMeta() instanceof BlockStateMeta) {
            BlockStateMeta blockStateMeta = (BlockStateMeta) itemStack.getItemMeta();
            if (blockStateMeta.getBlockState() instanceof ShulkerBox) {
                ShulkerBox shulkerBox = (ShulkerBox) blockStateMeta.getBlockState();
                Inventory boxInventory = shulkerBox.getInventory();
                for (ItemStack item : boxInventory.getContents()) {
                    if (item != null) {
                        if (ImpurityStackedItemFix.getPlugin().illegalUtils.isOverstacked(item)) {
                            item.setAmount(item.getMaxStackSize());
                            event.setCancelled(true);
                        }
                        if (ImpurityStackedItemFix.getPlugin().illegalUtils.hasIllegalEnchants(item)) {
                            for (Map.Entry<Enchantment, Integer> enchantmentIntegerEntry : item.getEnchantments().entrySet()) {
                                if (enchantmentIntegerEntry.getKey().canEnchantItem(item)) {
                                    item.addEnchantment(enchantmentIntegerEntry.getKey(), enchantmentIntegerEntry.getKey().getMaxLevel());
                                } else {
                                    item.removeEnchantment(enchantmentIntegerEntry.getKey());
                                }
                                event.setCancelled(true);
                            }
                        }
                    }
                }
                blockStateMeta.setBlockState(shulkerBox);
                itemStack.setItemMeta(blockStateMeta);
            }
        }
    }
}