package com.fattied.fl0jah.main;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
// import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
// import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
// import org.bukkit.event.entity.PlayerDeathEvent;
// import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.network.Connection;

// import net.minecraft.network.protocol.Packet;
// import net.minecraft.server.level.ServerPlayer;

// import net.minecraft.network.protocol.game.ClientboundAnimatePacket; // Eclipse could not find
// import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.*;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.*;
public class Main extends JavaPlugin implements Listener, CommandExecutor{
	
	@Override
	public void onEnable() {
//		 ShapedRecipe recipe;
//		 EntityPlayer player;
//		 GameProfile prof;
//		 ServerPlayer pl; Mojang mapping (Cannot find)
		
		System.out.println("[ExperimentPlugin] Plugin Successfully Enabled!");
		
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("npc").setExecutor(this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[ExperimentPlugin] Plugin Successfully Disabled!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			CraftPlayer cp = (CraftPlayer) player;
			ServerPlayer serv_plyr = cp.getHandle();
			
			// Create npc profile
			// Registers new UUID
			// Maps npc to a texture skin
			GameProfile prof = new GameProfile(UUID.randomUUID(), "Test NPC");
			prof.getProperties().put("textures", new Property("textures", 
					"ewogICJ0aW1lc3RhbXAiIDogMTc0MTk2NzUxMjQ0MSwKICAicHJvZmlsZ"
					+ "UlkIiA6ICI1MDMyYTA2NWQ5MWQ0NTgyYjZmODM0MDRlMGYyOTA4MiIsC"
					+ "iAgInByb2ZpbGVOYW1lIiA6ICJNYWNCb29rUHJvTTIiLAogICJzaWduYX"
					+ "R1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICA"
					+ "iU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5t"
					+ "aW5lY3JhZnQubmV0L3RleHR1cmUvYjE3Yzg5MzQ0ZTdiMzdiN2FkMDIxY"
					+ "TNlOWEzODk2NzBjYWNhMTViNzAxM2VlYjBiZWEwYTViMDI3YmFmZTIxNS"
					+ "IsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJ"
					+ "zbGltIgogICAgICB9CiAgICB9CiAgfQp9", 
					"K+zyFgjK1ukXnc5rYKsYPw0lNku7Zf6AoA3b3kgrbPBl4ZIvif/f4OAKQyu"
					+ "L4qJKAKvj9EWhq9ep53ukpPFsKOMcgTEDWw7lkfWh+uzfof2vkAvUcnzR"
					+ "FF0iBbwzOUY9RSVgA3pXN5MfR0BL295pRHqulJoqeZSwYc2e9tU10uEDc"
					+ "bG2j7JLFLNQKR/UL/ilG4pxT7RwhSC49EY4LrzxFWYZmKh4wK5L6jrbzk"
					+ "Lhyua8EifLfRaBg6S8PfRSaDkrV/cmspLV6/y7WokfZmwBPPllYoHt4ta"
					+ "FUB8todxG3mxStN1ond5vK6eeqn6HrKHAKSfO8N0AxWrrsVCnwI6gy4Cw"
					+ "84zMBV3ihMxktKZGZ/DO1xd9UaqFS25I0igZzfclDHbn6iiq6iYWofLbQ"
					+ "WhhMaw/042+sZ76Ume6d9wkIl9VxOsSthDtmVGQKNEEiUeWTJZVDT9br0"
					+ "gboJ1tiLKrqYYNyyQbL6FNRqJwsB5gy0vw3hG6xncRqfFB13nMl/G+cDo"
					+ "XWstXm6+DZvpIsgQsDL2HSrk22iczWvX2BYX5qDldpR1b0QQSldhue98C"
					+ "XtjbQqkHGIKIeD7ksMh7uYwocyt9T0/1L/cGBnVwqpFwQOoWJ5WwQhxio"
					+ "xtl7nlp2lzg/FUdOsUuub1lQrtsQaeyU9AWsPkLpEP126CbdC1XyjE="));
			
			System.err.println("Player Handle: " + serv_plyr.toString());
			System.err.println("Player Server World Handle" + serv_plyr.serverLevel());
			
			// Register npc game profile to minecraft server
			ServerPlayer npc = new ServerPlayer(serv_plyr.getServer(), 
					serv_plyr.serverLevel(), 
					prof, ClientInformation.createDefault());
			
			System.err.println("NPC Validity: " + npc.toString());
			
			// Requires establishing connection between server and npc
			npc.connection = new ServerGamePacketListenerImpl(serv_plyr.getServer(), 
					new Connection(PacketFlow.SERVERBOUND), 
					npc, 
					CommonListenerCookie.createInitial(prof, false));
			
			// Set npc's position in world
			npc.setPos(player.getLocation().getX(), 
					player.getLocation().getY(), 
					player.getLocation().getZ() + 2); // Set position
			
			// Get player connection (to server) to send packets
			ServerGamePacketListenerImpl connection = serv_plyr.connection;
			
			System.err.println("Player connection Validity: " + connection.toString());
			
			// Inform player of new 'player' joining server
			connection.send(new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, npc));
			
			// Cast Error - connection.send(new ClientboundAddEntityPacket(npc, (ServerEntity) player));
			ServerEntity serv_ent = new ServerEntity(npc.serverLevel(),
					npc,
					0,
					false,
					packet -> {},
					Set.of());
			// Not sure of purpose
			// Maybe sending npc entity data to player
			// Replacing 'npc' w/ player spawns second player. 
			// Interacting w/ self causes error
			connection.send(npc.getAddEntityPacket(serv_ent));
			
			// Magic stuff. Must research
			SynchedEntityData data = npc.getEntityData();
			byte bitmask = (byte) (0x01 | 0x04 | 0x08 | 0x10 | 0x20 | 0x40); // = 127
			data.set(new EntityDataAccessor<>(17, EntityDataSerializers.BYTE), bitmask);
			
			connection.send(new ClientboundSetEntityDataPacket(npc.getId(), data.getNonDefaultValues()));
			
			float yaw = 1f;
			float pitch = 1f;
			connection.send(new ClientboundRotateHeadPacket(npc, (byte) ((yaw % 360) * 256 / 360)));
			connection.send(new ClientboundMoveEntityPacket.Rot(npc.getBukkitEntity().getEntityId(), 
					(byte) ((yaw % 360) * 256 / 360), 
					(byte) ((pitch % 360) * 256 / 360), 
					true));
			
			Bukkit.getScheduler().runTaskLater(this, new Runnable() {

				@Override
				public void run() {
					connection.send(new ClientboundPlayerInfoRemovePacket(Arrays.asList(npc.getUUID())));
				}
				
			}, 20L);
		}else {
			System.out.println("[ExperimentPlugin] Command request cannot be posted from console!");
		}
		
		return true;
	}
}
