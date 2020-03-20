package com.gamepathics.Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamepathics.Main.Main;

public class ConfigManager {

	static Main plugin = Main.getPlugin(Main.class);
	static FileConfiguration config = plugin.getConfig();
	
	public static void loadConfigFile()
	{
		
			MessageManager.fireStickName = config.getString("Sticks.Fire Stick.Name");
			MessageManager.fireStickLore = config.getString("Sticks.Fire Stick.Lore");

			MessageManager.flightStickName = config.getString("Sticks.Flight Stick.Name");
			MessageManager.flightStickLore = config.getString("Sticks.Flight Stick.Lore");
			
			MessageManager.freezeStickName = config.getString("Sticks.Freeze Stick.Name");
			MessageManager.freezeStickLore = config.getString("Sticks.Freeze Stick.Lore");
			
			MessageManager.lightningStickName = config.getString("Sticks.Lightning Stick.Name");
			MessageManager.lightningStickLore = config.getString("Sticks.Lightning Stick.Lore");
			
			MessageManager.enderStickName = config.getString("Sticks.Ender Stick.Name");
			MessageManager.enderStickLore = config.getString("Sticks.Ender Stick.Lore");
			
			

	}
	
	public static void createConfigFile()
	{
		
		//STICKS
		config.set("Sticks.Fire Stick.Name", MessageManager.fireStickName);
		config.set("Sticks.Fire Stick.Lore", MessageManager.fireStickLore);

		config.set("Sticks.Flight Stick.Name", MessageManager.flightStickName);
		config.set("Sticks.Flight Stick.Lore", MessageManager.flightStickLore);
			
		config.set("Sticks.Freeze Stick.Name", MessageManager.freezeStickName);
		config.set("Sticks.Freeze Stick.Lore", MessageManager.freezeStickLore);
			
		config.set("Sticks.Lightning Stick.Name", MessageManager.lightningStickName);
		config.set("Sticks.Lightning Stick.Lore", MessageManager.lightningStickLore);
			
		config.set("Sticks.Ender Stick.Name", MessageManager.enderStickName);
		config.set("Sticks.Ender Stick.Lore", MessageManager.enderStickLore);
			

		
			
			
			
			
			plugin.saveConfig();	

		
	}
	
}
