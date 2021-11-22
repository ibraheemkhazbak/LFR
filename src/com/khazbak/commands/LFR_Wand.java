package com.khazbak.commands;


import com.khazbak.customItems.WireTool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class LFR_Wand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player p= ((Player) commandSender);
            p.getInventory().addItem(WireTool.WIRE_TOOL);
            return true;
        }

        return false;
    }
}
