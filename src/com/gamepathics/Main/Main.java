package com.gamepathics.Main;

import org.bukkit.Bukkit;
import org.bukkit.World;
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

		//generateOres(1, 120);
		
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
				EventManager.generateOre(Bukkit.getWorlds().get(0));
			}
			
		}, timeFromStart, time);
	}



}
