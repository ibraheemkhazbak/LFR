package com.khazbak.components;

import com.khazbak.PluginMethods;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.block.BlockPistonExtendEvent;

import java.util.List;

public class Crusher extends IComponent {

    public Crusher(Block block, Sign sign,int maxPower) {
        super(block,sign,maxPower);
       componentName="Crusher";
        Component.components.put(PluginMethods.blockKey(block),this);
        updateSign();
    }


    public void function(BlockPistonExtendEvent e) {
        if(isPowered()) {
            try {
                List<Block> blocks;
                blocks = e.getBlocks();
                blocks.get(0).breakNaturally();
                e.setCancelled(true);
            } catch (Exception exception) {

            }
        }

    }

}
