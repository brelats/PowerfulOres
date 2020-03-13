package com.gamepathics.Main;

import org.bukkit.plugin.java.JavaPlugin;

import com.gamepathics.Managers.CommandsManager;
import com.gamepathics.Managers.EventsManager;
import com.gamepathics.Managers.MessagesManager;

public class Main extends JavaPlugin{

		
	@Override
	public void onEnable() 
	{

		System.out.println(MessagesManager.powerfulOresPrefix + " Plugin Enabled");
		super.onEnable();
	}
	
	@Override
	public void onDisable() 
	{
		System.out.println(MessagesManager.powerfulOresPrefix + " Plugin Disabled");

		super.onDisable();
	}





}
