package com.khazbak.events.customevent;


import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GenOffEvent extends Event implements Cancellable {
    private String name;


    private Block block;
    private boolean cancelled=false;
    private static final HandlerList handlers = new HandlerList();

    public GenOffEvent(Block block) {
        name="Furnace Off Event";
        this.block=block;
    }


    public Block getBlock() {
        return block;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public String getEventName() {
        return name;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled=b;
    }
}
