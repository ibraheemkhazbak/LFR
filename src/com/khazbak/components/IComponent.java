package com.khazbak.components;

import com.khazbak.events.ComponentSign;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class IComponent extends Component{
    private int power;
    private final int maxPower;
    private OComponent in;
    public IComponent(Block block, Sign sign, int maxPower) {
        super(block, sign);
        this.maxPower=maxPower;
        this.power=0;
    }
    public void updateSign(){
        info[0]="&9[&f"+componentName+"&9]&r";
        info[1]= "&7"+getPower()+"/"+maxPower;
        info[2]=isPowered()?"&aPowered":"&cNo Power";
        info[3]=isConnected()?"&aConnected":"&cDisconnected";
        ComponentSign.setSign(getSign(),info);
    }


    public boolean isConnected() {
        return in != null;
    }

    public boolean isPowered() {
        return power == maxPower;
    }

    public void setIn(OComponent in) {
        this.in=in;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getMaxPower() {
        return maxPower;
    }
}
