package com.khazbak.events;

import com.khazbak.components.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class WandUse implements Listener {
    public static ArrayList<Component> connectionCache=new ArrayList<>();

    @EventHandler
    public void onWandUse(PlayerInteractEvent e){

    }




}
