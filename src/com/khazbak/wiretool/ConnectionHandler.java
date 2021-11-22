package com.khazbak.wiretool;

import com.khazbak.components.Component;
import com.khazbak.components.IComponent;
import com.khazbak.components.OComponent;

import java.util.ArrayList;

public class ConnectionHandler {
    private static ArrayList<Component> componentsToConnect;
    enum status{
        FIRST_CONNECTION,
        LAST_CONNECTION,
        CANT_CONNECT
    }
    public static status connect(Component component){
        componentsToConnect.add(component);
        if(componentsToConnect.size()==2){
            normalizeConnection();
            if(componentsToConnect.get(0) instanceof OComponent){
                OComponent oComponent=(OComponent) componentsToConnect.get(0);
                IComponent iComponent=(IComponent) componentsToConnect.get(1);
                oComponent.addOutput(iComponent);
                iComponent.setIn(oComponent);
            }
            componentsToConnect.clear();
            return status.LAST_CONNECTION;
        }else{
            return status.FIRST_CONNECTION;
        }
    }

    private static boolean normalizeConnection() {
    if(componentsToConnect.get(0) instanceof IComponent){
        Component temp=componentsToConnect.get(0);
        componentsToConnect.set(0,componentsToConnect.get(1));
        componentsToConnect.set(1,temp);
    return true;
    }
    return false;
    }


}
