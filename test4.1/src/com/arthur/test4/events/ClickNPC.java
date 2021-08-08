package com.arthur.test4.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Class when a NPC is clicked on.
 *
 * @author Arthur
 */
public class ClickNPC implements Listener {

    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method handling clicking on NPC.
     *
     * It sends a message to the player if a NPC is clicked.
     *
     * @param event of type "RightClickNPC"
     */
    @EventHandler
    public void onClick(RightClickNPC event) {
        Player player = event.getPlayer();
        player.sendMessage("DID IT WORK ....??");
    }
}
