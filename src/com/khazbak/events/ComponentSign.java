package com.khazbak.events;

import com.khazbak.components.Component;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;


public class ComponentSign implements Listener {
    public static void setSign(Sign sign,String[] args){
        for (int i=0;i<args.length;i++) {
            sign.setLine(i, ChatColor.translateAlternateColorCodes('&', args[i]));

        }


        sign.update();
    }
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Component.addComponent(e);
    }
    @EventHandler
    public void onSignBreak(BlockBreakEvent e){
                Component.RemoveComponentEventHandler(e);
           }
}
