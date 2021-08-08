package com.arthur.test4;

import com.arthur.test4.commands.commandCreateNpc;
import com.arthur.test4.events.ClickNPC;
import com.arthur.test4.events.test4Events;
import com.mojang.brigadier.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class when launching the plugin.
 *
 * @author Arthur
 */
public class test4 extends JavaPlugin {

    // **************************************************
    // Public methods
    // **************************************************
    /**
     * Method when plugin is enabled.
     */
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new test4Events(), this);
        getCommand("createnpc").setExecutor(new commandCreateNpc());
        this.getServer().getPluginManager().registerEvents(new ClickNPC(), this);
        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                PacketReader reader = new PacketReader();
                reader.inject(player);
            }
        }
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Test4] is enabled!");
    }

    /**
     * Method when plugin is disabled.
     */
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Test4] is disabled!");
        for (Player player : Bukkit.getOnlinePlayers()) {
            PacketReader reader = new PacketReader();
            reader.uninject(player);
        }
    }

}

