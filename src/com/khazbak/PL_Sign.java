package com.khazbak;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;

public class PL_Sign {

    public static Block getBlockOn(Block block){
    Block result=null;
        BlockData data = block.getBlockData();
        if(data instanceof  Directional){
            Directional directional=(Directional) data;
            result=block.getRelative(directional.getFacing().getOppositeFace());
    }
        return result;

    }

}
