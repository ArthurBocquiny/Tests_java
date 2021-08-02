package com.arthur.test1;

import com.arthur.test1.commands.test1Commands;
import com.arthur.test1.events.test1Events;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class when launching plugin.
 *
 * @author Arthur
 */
public class test1 extends JavaPlugin {

    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method when plugin is enabled.
     */
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new test1Events(), this);
        getCommand("test").setExecutor(new test1Commands(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Test1] is enabled!");
    }
    /**
     * Method when plugin is disabled.
     */
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Test1] is disabled!");
    }
}
