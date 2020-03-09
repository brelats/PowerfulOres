package com.gamepathics.Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	
	static final String powerful_prefix = "[PowerfulOres]";
	
	@Override
	public void onEnable() 
	{

		System.out.println(powerful_prefix + " Plugin Enabled");
		super.onEnable();
	}
	
	@Override
	public void onDisable() 
	{
		System.out.println(powerful_prefix + " Plugin Disabled");

		super.onDisable();
	}





}
