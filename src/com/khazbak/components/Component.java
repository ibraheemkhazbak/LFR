package com.khazbak.components;

import com.khazbak.PL_Sign;
import com.khazbak.PluginMethods;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;

import java.util.LinkedHashMap;

import static com.khazbak.PluginMethods.blockKey;

public class Component {
    public String componentName;
    private Block block;
    private Sign sign;
    protected String[] info;
    public static LinkedHashMap<String, Component> components=new LinkedHashMap<>();

    public Component(Block block, Sign sign) {
        this.block = block;
        this.sign = sign;
        info=new String[4];
    }
    public void function(Object o){

    }

    public static void addComponent(SignChangeEvent e){
        Player player=e.getPlayer();
        Block block=e.getBlock();
        Block onBlock= PL_Sign.getBlockOn(block);


        if(onBlock!=null) {
            // add crusher
            if (e.getLine(0).equalsIgnoreCase("[crusher]")) {
                if (onBlock.getType() == Material.PISTON) {
                   e.setCancelled(true);
                    new Crusher(onBlock,(Sign) block.getState(),10000);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully placed component"));
                    return;
                }

                }else if(e.getLine(0).equalsIgnoreCase("[generator]")) {
                PluginMethods.ConsoleLog(onBlock.getType().toString());
                if (onBlock.getType() == Material.FURNACE) {
                    e.setCancelled(true);
                    new Generator(onBlock, (Sign) block.getState());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully placed component"));
                    return;
                }                    //TODO: ADD COMPONENTS HERE

            }
        }
    }
    public void connect(){

    }
    public Sign getSign() {
        return sign;
    }
    public static boolean componentExists(Block block){
        return Component.components.containsKey(blockKey(block));
    }
    public static void RemoveComponentEventHandler(BlockBreakEvent e){
        Player player=e.getPlayer();
        Block block=e.getBlock();
        Block onBlock = PL_Sign.getBlockOn(block);
        if(componentExists(block)){
            components.remove(PluginMethods.blockKey(block));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cComponent Successfully removed"));

        }else if(e.getBlock().getType().toString().endsWith("WALL_SIGN")){
            String blockKey=PluginMethods.blockKey(onBlock);
            if(Component.componentExists(onBlock)){
                Component.components.remove(blockKey);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cComponent Successfully removed"));

            }


        }


    }

    public Block getBlock() {
        return block;
    }

    public static Component getComponent(Block block){
        if(componentExists(block)){
            return components.get(blockKey(block));
        }
        return null;
    }
}
