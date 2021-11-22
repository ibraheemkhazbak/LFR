package com.khazbak.components;

import com.khazbak.PluginMethods;
import com.khazbak.events.ComponentSign;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

import java.util.ArrayList;

public class OComponent extends Component {
    private final int maxOutputs;
    protected ArrayList<Component> outputs;
        protected int outputPower;
        protected int maxOutputPower;
    public OComponent(Block block, Sign sign, int maxOutputs,int maxOutputPower) {
        super(block, sign);
        outputs=new ArrayList<>();
        this.maxOutputs=maxOutputs;
        this.outputPower=0;
        this.maxOutputPower=maxOutputPower;
    }

    public void addOutput(IComponent component){
        if(outputs.size()>=maxOutputs){
            PluginMethods.ConsoleLog("Reached limit of outputs");
        }else{
            outputs.add(component);
        }
    }
    protected boolean isConnected() {
    return outputs.size()>0;
    }

    protected boolean canGenerate() {
        //TODO: MAKE IT CHECK IF ITS READY
        return false;
    }
}
