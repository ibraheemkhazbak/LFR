package com.khazbak.components;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

import java.util.ArrayList;

public abstract class Out extends Component{
    ArrayList<Component> out = new ArrayList<>();
    int maxOut;
    int maxPower;
    int outPower;
    public Out(Block block, Sign sign,int maxOut,int maxPower) {
     super(block,sign);
        this.maxOut = maxOut;
        this.maxPower = maxPower;
    }

    public void addOut(Component component){
        if (out.size()!=maxOut)
            out.add(component);
    }
    public boolean isConnected(){
        return out.size()>0;
    }

}
