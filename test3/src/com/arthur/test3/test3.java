package com.arthur.test3;

import com.arthur.test3.events.zombieEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class when the plugin is launched.
 *
 * @author Arthur
 */
public class test3 extends JavaPlugin {
    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new zombieEvent(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Test3] is enabled!");
    }
    /**
     * Method when the plugin is disabled.
     */
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Test3] is disabled!");
    }
}
