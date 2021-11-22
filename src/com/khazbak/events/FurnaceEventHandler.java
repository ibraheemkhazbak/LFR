package com.khazbak.events;

import com.khazbak.Main;
import com.khazbak.PluginMethods;
import com.khazbak.components.Component;
import com.khazbak.components.Generator;
import com.khazbak.events.customevent.GenOffEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class FurnaceEventHandler implements Listener {
    @EventHandler
    public void burnEvent(FurnaceBurnEvent e){

        Block block = e.getBlock();
        GenOffEvent genOffEvent = new GenOffEvent(e.getBlock());

        Component component=Component.getComponent(block);
        if(component!=null && component instanceof Generator){
            Generator generator=((Generator)component);
            generator.function(e);
            Main.scheduler.scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getPluginManager().callEvent(genOffEvent);

                }
            },e.getBurnTime()+1);

        }
    }
    @EventHandler
    public void genOff(GenOffEvent e){
        Furnace furnace=((Furnace) e.getBlock().getState());
        Generator generator=(Generator) Component.getComponent(e.getBlock());

        if(furnace.getBurnTime()==0){
            generator.setGenerating(false);
            generator.updateSign();
        }
    }

    // WHEN A FURNACE INVENTORY IS OPENED
    @EventHandler
    public void inventoryInteract(InventoryCloseEvent e){
     Block block=   e.getInventory().getLocation().getBlock();

        if(block.getType()== Material.FURNACE){
            if (Component.componentExists(block)) {
                if(Component.getComponent(block) instanceof  Generator){
                    ((Generator)Component.getComponent(block)).updateSign();

                }
            }
     }
    }
}
