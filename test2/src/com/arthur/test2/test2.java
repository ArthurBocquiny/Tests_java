package com.arthur.test2;

import com.arthur.test2.events.test2Events;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class when launching the plugin.
 *
 * @author Arthur
 */
public class test2 extends JavaPlugin {

    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method when plugin is enabled.
     */
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new test2Events(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Test2] is enabled!");
    }

    /**
     * Method when plugin is disabled.
     */
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Test2] is disabled!");
    }
}
