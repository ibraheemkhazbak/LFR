package com.khazbak;

import com.khazbak.commands.LFR_Wand;
import com.khazbak.enchants.WireTool;
import com.khazbak.events.FurnaceEvent;
import com.khazbak.events.PistonTrig;
import com.khazbak.events.ComponentSign;
import com.khazbak.events.WandUse;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin {
    public static JavaPlugin plugin ;
    public static BukkitScheduler scheduler;

    public static String pluginName ="LunarFactoriesRemake";
    @Override
    public void onEnable(){
        PluginMethods.ConsoleLog("Enabled");
        plugin=this;
        scheduler=getServer().getScheduler();

        getServer().getPluginManager().registerEvents(new ComponentSign(), this);
        getServer().getPluginManager().registerEvents(new PistonTrig(), this);
        getServer().getPluginManager().registerEvents(new WandUse(), this);
        getServer().getPluginManager().registerEvents(new FurnaceEvent(), this);

        getCommand("lfr").setExecutor(new LFR_Wand());
    }

    @Override
    public void onDisable() {
        System.out.println("[Lunar Factories Remake]: Disabled");
    }
}
