package com.fattied.fl0jah.main;

import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.level.EntityPlayer;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		ShapedRecipe recipe;
		EntityPlayer player;
		GameProfile prof;
		System.out.println("[ExperimentPlugin] Plugin Successfully Enabled!");
	}
	
	@Override
	public void onDisable() {
		System.out.println("[ExperimentPlugin] Plugin Successfully Disabled!");
	}
}
