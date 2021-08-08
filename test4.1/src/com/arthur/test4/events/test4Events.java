package com.arthur.test4.events;

import com.arthur.test4.NPC;
import com.arthur.test4.PacketReader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Class handling the events.
 *
 * @author Arthur
 */
public class test4Events implements Listener {
    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method handling sending packets
     * of the NPCs to the player who joined, and connecting to his packets.
     *
     * @param event of type "PlayerJoinEvent"
     */
    @EventHandler
    public static void onJoin(PlayerJoinEvent event) {
        NPC.addJoinPacket(event.getPlayer());
        PacketReader reader = new PacketReader();
        reader.inject(event.getPlayer());
    }
    /**
     * Method handling the disconnection of a player packet.
     *
     * @param event of type "PlayerQuitEvent"
     */
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        PacketReader reader = new PacketReader();
        reader.uninject(event.getPlayer());
    }

}
