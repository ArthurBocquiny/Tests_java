package com.arthur.test4.commands;

import com.arthur.test4.NPC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class handling the command to spawn fake NPCs.
 *
 * @author Arthur
 */
public class commandCreateNpc implements CommandExecutor {

    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method handling the spawn of a new NPC.
     *
     * It can take 1 arg after the command.
     *
     * If no arg, the skin of the NPC and his name will be by default the same as the one
     * launching the command.
     *
     * If there is an arg, the skin of the NPC and his name will be the same as the one put in the arg.
     * If the player's name is not valid (doesn't exist), the skin will be by default the same as the one
     * launching the command.
     *
     * @param sender of type "CommandSender", command of type "Command", String label, String[] args.
     * @return true or false.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("createnpc")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            Player player = (Player) sender;
            if (args.length == 0) {
                NPC.createNPC(player, player.getName());
                player.sendMessage("NPC Created");
                return true;
            }
            NPC.createNPC(player, args[0]);
            player.sendMessage("NPC Created");
            return true;
        }
        return false;
    }
}
