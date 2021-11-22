package com.khazbak.components;

import com.khazbak.PluginMethods;
import com.khazbak.events.ComponentSign;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.block.Sign;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class Generator extends OComponent{
    boolean generating;
    public Generator(Block block, Sign sign) {
        super(block, sign, 1,100000);
        Component.components.put(PluginMethods.blockKey(block),this);
        componentName="Generator";
        generating=false;
        updateSign();

    }

    public void function(FurnaceBurnEvent e) {
        setGenerating(true);
        outputPower = maxOutputPower;
        updateSign();

    }
public void setGenerating(boolean b){
        generating=b;
    outputPower=generating?maxOutputPower:0;
}

    public void updateSign() {
        info[0]="&9[&f"+componentName+"&9]&r";
        info[1]= "&7"+outputPower+"/"+maxOutputPower;
        info[2]= generating?"&aGenerating...":"&cNot Ready";
        String connectedText=isConnected()?"&a[C]":"&c[dc]";
        String hasFuelText=hasFuel()?"&aHas Fuel":"&cOut Of Fuel";
        info[3]=hasFuelText+" "+connectedText;
        ComponentSign.setSign(getSign(),info);
    }

    private boolean hasFuel() {
    Furnace furnace;
        if(getBlock().getType() == Material.FURNACE){
        furnace=(Furnace) getBlock().getState();

        if(furnace.getInventory().getFuel()!=null){

            return furnace.getInventory().getFuel().getAmount()>0;
        }
    }
        return false;
    }


}
