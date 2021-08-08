package com.arthur.test4;

import com.arthur.test4.events.RightClickNPC;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.Packet;
import net.minecraft.server.v1_16_R3.PacketPlayInUseEntity;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Class reading the packets.
 *
 * @author Arthur
 */
public class PacketReader {

    // **************************************************
    // Fields
    // **************************************************
    /** Variable containing the player's channel. */
    Channel channel;

    // **************************************************
    // Constants
    // **************************************************
    /** Variable to init the map containing the players' channels. */
    public static Map<UUID, Channel> channels = new HashMap<UUID, Channel>();

    // **************************************************
    // Public methods
    // **************************************************
    /**
     *  Connect to the player's packets and decode them.
     *
     * @param player of type Player
     * @return void
     */
    public void inject(Player player) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        channel = craftPlayer.getHandle().playerConnection.networkManager.channel;
        channels.put(player.getUniqueId(), channel);

        if (channel.pipeline().get("PacketInjector") != null)
            return;

        channel.pipeline().addAfter("decoder", "PacketInjector", new MessageToMessageDecoder<PacketPlayInUseEntity>() {

            @Override
            protected void decode(ChannelHandlerContext channel, PacketPlayInUseEntity packet, List<Object> arg) throws Exception {
                arg.add(packet);
                readPacket(player, packet);
            }
        });
    }

    /**
     *  Disconnect from the player's packets.
     *
     * @param player of type Player
     * @return void
     */
    public void uninject(Player player) {
        channel = channels.get(player.getUniqueId());
        if (channel.pipeline().get("PacketInjector") != null) {
            channel.pipeline().remove("PacketInjector");
        }
    }

    /**
     *  Read the packets of a player.
     *
     * @param player of type Player, packet of any type
     * @return void
     */
    public void readPacket(Player player, Packet<?> packet) {

        if (packet.getClass().getSimpleName().equalsIgnoreCase("PacketPlayInUseEntity")) {

            if (getValue(packet, "action").toString().equalsIgnoreCase("ATTACK")) {
                int id2 = (int) getValue(packet, "a");
                for (EntityPlayer npc : NPC.getNPCs()) {
                    if (npc.getId() == id2) {
                        Bukkit.getScheduler().scheduleSyncDelayedTask(test4.getPlugin(test4.class), new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.getPluginManager().callEvent(new RightClickNPC(player, npc));
                            }
                        }, 0);
                    }
                }
                return;
            }
            if (getValue(packet, "d").toString().equalsIgnoreCase("OFF_HAND"))
                return;
            if (getValue(packet, "action").toString().equalsIgnoreCase("INTERACT_AT"))
                return;

            int id = (int) getValue(packet, "a");

            if (getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")) {
                for (EntityPlayer npc : NPC.getNPCs()) {
                    if (npc.getId() == id) {
                        System.out.println(npc.getId());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(test4.getPlugin(test4.class), new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.getPluginManager().callEvent(new RightClickNPC(player, npc));
                            }
                        }, 0);
                    }
                }
            }
        }
    }

    // **************************************************
    // Private methods
    // **************************************************
    private Object getValue(Object instance, String name) {
        Object result = null;

        try {
            Field field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);

            result = field.get(instance);

            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
