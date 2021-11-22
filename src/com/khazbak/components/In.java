package com.khazbak.components;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

import java.util.ArrayList;

public abstract class In extends Component{
    protected ArrayList<Component> in = new ArrayList<>();
    protected int maxIn;
    protected  int maxPower;

    public In(Block block, Sign sign,int maxIn,int maxPower) {
        super(block, sign);
        this.maxIn=maxIn;
        this.maxPower=maxPower;
    }


    protected void addIn(Component component){
        if (in.size()!=maxIn)
            in.add(component);
    }

    protected int getPower(){
        return 0;
    }
    protected boolean isPowered(){
        return getPower()==maxPower;
    }
    protected boolean isConnected(){
        return in.size()>0;
    }

}
