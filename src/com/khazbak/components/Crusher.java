package com.khazbak.components;

import com.khazbak.events.ComponentSignHandler;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.block.BlockPistonExtendEvent;

import java.util.List;

public class Crusher extends In {

    public Crusher(Block block, Sign sign) {

        super(block,sign,1,1000);
       componentName="Crusher";
        updateSign();
    }

    public void updateSign(){
        info[0]="&9[&f"+componentName+"&9]&r";
        info[1]= "&7"+getPower()+"/"+maxPower;
        info[2]=isPowered()?"&aPowered":"&cNo Power";
        info[3]=isConnected()?"&aConnected":"&cDisconnected";
        ComponentSignHandler.setSign(getSign(),info);
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
