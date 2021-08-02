package com.arthur.test2.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Class handling the events.
 *
 * @author Arthur
 */
public class test2Events implements Listener {
    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method handling the cancel interact event of the snowball on right click.
     *
     * @param e of type "PlayerInteractEvent"
     */
    @EventHandler
    public static void onPlayerRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() != null && (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR))) {
            ItemStack is = e.getItem();
            if (is != null && is.getType().equals(Material.SNOWBALL)) {
                e.setCancelled(true);
                Bukkit.getServer().dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "tellraw " + p.getName() +
                                " {\"text\":\"Click me ! :D\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://google.fr\"}}");
            }
        }
    }
}
