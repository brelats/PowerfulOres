package com.gamepathics.Main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import com.gamepathics.Managers.CommandList;
import com.gamepathics.Managers.CommandManager;
import com.gamepathics.Managers.EventManager;
import com.gamepathics.Managers.MessageManager;
import com.gamepathics.Managers.WorldManager;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() 
	{


		this.getCommand(CommandList.mainCommand).setExecutor((CommandExecutor) new CommandManager());
		this.getServer().getPluginManager().registerEvents(new EventManager(), this);
		this.getServer().getPluginManager().registerEvents(new WorldManager(), this);
		
		
		//1800 s = 30 min
		//36000 ticks = 1800 * 20
		generateOres(500, 500);  
		
		System.out.println(MessageManager.powerfulOresPrefix + " Plugin Enabled");
		super.onEnable();
	}
	
	@Override
	public void onDisable() 
	{
		
		System.out.println(MessageManager.powerfulOresPrefix + " Plugin Disabled");
		super.onDisable();
	}
	
	
	//timeFromStart son los ticks que pasan desde que se ejecuta por primera vez.
	//time son a los ticks que se ejecuta
	public void generateOres(int timeFromStart, int time)
	{
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				WorldManager.generateOre(Bukkit.getWorlds().get(0));
			}
			
		}, timeFromStart, time);
	}



}
