package com.gamepathics.Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamepathics.Main.Main;

public class ConfigManager {

	static Main plugin = Main.getPlugin(Main.class);
	static FileConfiguration config = plugin.getConfig();
	
	public static void loadConfigFile()
	{
			//STICK
			MessageManager.fireStickName = config.getString("Sticks.Fire Stick.Name");
			MessageManager.fireStickLore = config.getString("Sticks.Fire Stick.Lore");

			MessageManager.flightStickName = config.getString("Sticks.Flight Stick.Name");
			MessageManager.flightStickLore = config.getString("Sticks.Flight Stick.Lore");
			MessageManager.flightStickEnabled = config.getString("Sticks.Flight Stick.Flight Enabled");
			MessageManager.flightStickDisabled = config.getString("Sticks.Flight Stick.Flight Disabled");
			

			MessageManager.freezeStickName = config.getString("Sticks.Freeze Stick.Name");
			MessageManager.freezeStickLore = config.getString("Sticks.Freeze Stick.Lore");
			MessageManager.freezeStickEnabled = config.getString("Sticks.Freeze Stick.Freeze Enabled");
			MessageManager.freezeStickDisabled = config.getString("Sticks.Freeze Stick.Freeze Disabled");

			
			MessageManager.lightningStickName = config.getString("Sticks.Lightning Stick.Name");
			MessageManager.lightningStickLore = config.getString("Sticks.Lightning Stick.Lore");
			
			MessageManager.enderStickName = config.getString("Sticks.Ender Stick.Name");
			MessageManager.enderStickLore = config.getString("Sticks.Ender Stick.Lore");
			
			//FRAGMENTS
			MessageManager.fireFragmentName = config.getString("Fragments.Fire Fragment.Name");
			MessageManager.fireFragmentLore = config.getString("Fragments.Fire Fragment.Lore");

			MessageManager.flightFragmentName = config.getString("Fragments.Flight Fragment.Name");
			MessageManager.flightFragmentLore = config.getString("Fragments.Flight Fragment.Lore");
			
			MessageManager.freezeFragmentName = config.getString("Fragments.Freeze Fragment.Name");
			MessageManager.freezeFragmentLore = config.getString("Fragments.Freeze Fragment.Lore");

			MessageManager.lightningFragmentName = config.getString("Fragments.Lightning Fragment.Name");
			MessageManager.lightningFragmentLore = config.getString("Fragments.Lightning Fragment.Lore");
	
			MessageManager.enderFragmentName = config.getString("Fragments.Ender Fragment.Name");
			MessageManager.enderFragmentLore = config.getString("Fragments.Ender Fragment.Lore");
	
			//MESSAGES
			MessageManager.dontHavePerms = config.getString("Errors.Dont Have Permissions");
			MessageManager.stickDoesNotExist = config.getString("Errors.Stick Doesnt Exist");
			MessageManager.playerNotFound = config.getString("Errors.Player Not Found");
			MessageManager.oreDoesNotExist = config.getString("Errors.Ore Doesnt Exist");

			
			//CONFIG
			EventManager.enderScope = config.getInt("Ender Stick Scope");
			EventManager.lightningScope = config.getInt("Lightning Stick Scope");
			
			Main.generationTime = config.getInt("Ores Generation Time");


	}
	
	public static void createConfigFile()
	{
		
        config.options().copyDefaults(true);
        plugin.saveDefaultConfig();

//		//STICKS
//		config.set("Sticks.Fire Stick.Name", MessageManager.fireStickName);
//		config.set("Sticks.Fire Stick.Lore", MessageManager.fireStickLore);
//		config.set("Sticks.Flight Stick.Name", MessageManager.flightStickName);
//		config.set("Sticks.Flight Stick.Lore", MessageManager.flightStickLore);
//			
//		config.set("Sticks.Freeze Stick.Name", MessageManager.freezeStickName);
//		config.set("Sticks.Freeze Stick.Lore", MessageManager.freezeStickLore);
//			
//		config.set("Sticks.Lightning Stick.Name", MessageManager.lightningStickName);
//		config.set("Sticks.Lightning Stick.Lore", MessageManager.lightningStickLore);
//			
//		config.set("Sticks.Ender Stick.Name", MessageManager.enderStickName);
//		config.set("Sticks.Ender Stick.Lore", MessageManager.enderStickLore);
//			
//	
//		//FRAGMENTS
//		config.set("Fragments.Fire Fragments.Name", MessageManager.fireFragmentName);
//		config.set("Fragments.Fire Fragments.Lore", MessageManager.fireFragmentLore);
//
//		config.set("Fragments.Flight Fragments.Name", MessageManager.flightFragmentName);
//		config.set("Fragments.Flight Fragments.Lore", MessageManager.flightFragmentLore);
//			
//		config.set("Fragments.Freeze Fragments.Name", MessageManager.freezeFragmentName);
//		config.set("Fragments.Freeze Fragments.Lore", MessageManager.freezeFragmentLore);
//			
//		config.set("Fragments.Lightning Fragments.Name", MessageManager.lightningFragmentName);
//		config.set("Fragments.Lightning Fragments.Lore", MessageManager.lightningFragmentLore);
//			
//		config.set("Fragments.Ender Fragments.Name", MessageManager.enderFragmentName);
//		config.set("Fragments.Ender Fragments.Lore", MessageManager.enderFragmentLore);
//		
//		//MESSAGES
//		config.set("Messages.Errors.Dont Have Permissions", MessageManager.dontHavePerms);
//		config.set("Messages.Errors.Player Not Found", MessageManager.playerNotFound);
//		config.set("Messages.Errors.Stick Doesnt Exist", MessageManager.stickDoesNotExist);
//		config.set("Messages.Errors.Ore Doesnt Exist", MessageManager.oreDoesNotExist);
//
//			
//					
//		plugin.saveConfig();	

		
	}
	
}
