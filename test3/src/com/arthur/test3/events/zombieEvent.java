package com.arthur.test3.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Class handling the invincible zombie event.
 *
 * @author Arthur
 */
public class zombieEvent implements Listener {
    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method when the player join, making an invincible zombie spawn.
     *
     * @param event of type "PlayerJoinEvent"
     */
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        Entity entity = Bukkit.getWorld("world").spawnEntity(loc, EntityType.ZOMBIE);
        entity.setInvulnerable(true);
    }
}
