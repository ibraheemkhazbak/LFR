package com.khazbak.customItems;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WireTool {
  public  static ItemStack WIRE_TOOL;

    public static void init(){
        WIRE_TOOL=new ItemStack(Material.STICK,1);
        ItemMeta meta=WIRE_TOOL.getItemMeta();
        meta.addEnchant(Enchantment.LUCK,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("Wire tool");
        WIRE_TOOL.setItemMeta(meta);
    }
}
