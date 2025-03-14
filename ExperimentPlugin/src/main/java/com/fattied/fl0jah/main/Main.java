package com.fattied.fl0jah.main;

import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
//		 ShapedRecipe recipe;
//		 EntityPlayer player;
//		 GameProfile prof;
//		 ServerPlayer pl; Mojang mapping (Cannot find)
		
		System.out.println("[ExperimentPlugin] Plugin Successfully Enabled!");
		
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[ExperimentPlugin] Plugin Successfully Disabled!");
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		CraftPlayer cp = (CraftPlayer) e.getPlayer();
		
		cp.getHandle().connection.send();
		
		ServerPlayer ent;
	}
}
