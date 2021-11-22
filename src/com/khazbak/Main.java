package com.khazbak;

import com.khazbak.commands.LFR_Wand;
import com.khazbak.customItems.WireTool;
import com.khazbak.events.FurnaceEventHandler;
import com.khazbak.events.PistonTriggerEventHandler;
import com.khazbak.events.ComponentSignHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin {
    public static JavaPlugin plugin ;
    public static BukkitScheduler scheduler;

    public static String pluginName ="LunarFactoriesRemake";
    @Override
    public void onEnable(){

        plugin=this;
        scheduler=getServer().getScheduler();
        WireTool.init();

        getServer().getPluginManager().registerEvents(new ComponentSignHandler(), this);
        getServer().getPluginManager().registerEvents(new PistonTriggerEventHandler(), this);
        getServer().getPluginManager().registerEvents(new FurnaceEventHandler(), this);

        getCommand("lfr").setExecutor(new LFR_Wand());

        PluginMethods.ConsoleLog("Enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("[Lunar Factories Remake]: Disabled");
    }
}
