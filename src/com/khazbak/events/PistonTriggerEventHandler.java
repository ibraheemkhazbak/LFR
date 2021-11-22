package com.khazbak.events;

import com.khazbak.PluginMethods;
import com.khazbak.components.Component;
import com.khazbak.components.Crusher;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Piston;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;

import java.util.ArrayList;
import java.util.List;

public class PistonTriggerEventHandler implements Listener {
    @EventHandler
    public void onPistonTrigger(BlockPistonExtendEvent e) {
       if(Component.componentExists(e.getBlock())) {
           ((Crusher) Component.getComponent(e.getBlock())).function(e);
       }
    }
    }

