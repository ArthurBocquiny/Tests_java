package com.arthur.test1.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Class for events.
 *
 * @author Arthur
 */
public class test1Events implements Listener {

    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Handle the event when the player join.
     *
     * @param event of type "PlayerJoinEvent"
     */
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.DARK_PURPLE + "Welcome to the server ! :)");
    }

}
