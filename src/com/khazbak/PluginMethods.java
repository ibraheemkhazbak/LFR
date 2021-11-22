package com.khazbak;

import com.khazbak.components.Component;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class PluginMethods {
    public static void ConsoleLog(String message){
        System.out.println("["+Main.pluginName+"] : "+message);
    }
    public static String blockKey(Block block){
        Location location=block.getLocation();
        return  location.getWorld().getName()+location.getBlockX()+location.getBlockY()+location.getBlockZ()+"";
    }


}
