package com.arthur.test1.commands;

import com.arthur.test1.test1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Class for commands.
 *
 * @author Arthur
 */
public class test1Commands implements CommandExecutor {

    // **************************************************
    // Fields
    // **************************************************
    private test1 plugin;

    // **************************************************
    // Constructors
    // **************************************************
    /**
     * Parameterized constructor.
     *
     * @param plugin
     */
    public test1Commands(test1 plugin) {
        this.plugin = plugin;
    }

    // **************************************************
    // Public methods
    // **************************************************
    /**
     * It's the "/test <arg1>" command.
     *
     * @return True if success, False in case of errors.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
            return false;
        }
        Player player = (Player) sender;

        // /test
        if (cmd.getName().equalsIgnoreCase("test")) {
            if (args.length != 1) {
                player.sendMessage("§c§l(!) §cYou can only put one argument!");
                return false;
            }
            try {
                int i = Integer.parseInt(args[0]);

                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, ()->{
                    Inventory inv = Bukkit.createInventory(null, 9, "New inventory");
                    inv.setItem(0, new ItemStack(Material.DIAMOND));
                    player.openInventory(inv);
                }, i);
            }
            catch (NumberFormatException ex) {
                player.sendMessage("§c§l(!) §cYou can only put an int as an argument!");
                return false;
            }
        }
        return true;
    }
}
