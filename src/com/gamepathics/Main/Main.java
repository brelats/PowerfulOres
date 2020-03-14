package com.gamepathics.Main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import com.gamepathics.Managers.CommandList;
import com.gamepathics.Managers.CommandManager;
import com.gamepathics.Managers.EventManager;
import com.gamepathics.Managers.MessageManager;


public class Main extends JavaPlugin{

		
	@Override
	public void onEnable() 
	{

		this.getCommand(CommandList.mainCommand).setExecutor((CommandExecutor) new CommandManager());
		this.getServer().getPluginManager().registerEvents(new EventManager(), this);

		
		System.out.println(MessageManager.powerfulOresPrefix + " Plugin Enabled");
		super.onEnable();
	}
	
	@Override
	public void onDisable() 
	{
		
		System.out.println(MessageManager.powerfulOresPrefix + " Plugin Disabled");
		super.onDisable();
	}



}
