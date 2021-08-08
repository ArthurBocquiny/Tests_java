package com.arthur.test4.events;

import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Class when clicking on NPC.
 *
 * @author Arthur
 */
public class RightClickNPC extends Event implements Cancellable {

    // **************************************************
    // Constants
    // **************************************************
    private final Player player;
    private final EntityPlayer npc;
    private boolean isCancelled;
    private static final HandlerList HANDLERS = new HandlerList();

    // **************************************************
    // Constructors
    // **************************************************
    public RightClickNPC(Player player, EntityPlayer npc) {
        this.player = player;
        this.npc = npc;
    }

    // **************************************************
    // Public methods
    // **************************************************
    public Player getPlayer() {
        return player;
    }

    public EntityPlayer getNPC() {
        return npc;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean arg) {
        isCancelled = arg;
    }
}
