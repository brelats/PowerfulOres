package com.gamepathics.Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamepathics.Main.Main;
import com.gamepathics.Sticks.EnderStick;
import com.gamepathics.Sticks.FireStick;
import com.gamepathics.Sticks.FlightStick;
import com.gamepathics.Sticks.FreezeStick;
import com.gamepathics.Sticks.LightningStick;

public class ConfigManager {

	static Main plugin = Main.getPlugin(Main.class);
	static FileConfiguration config = plugin.getConfig();
	
	public static void loadConfigFile()
	{
			//STICK
			MessageManager.fireStickName = config.getString("Sticks.Fire Stick.Name");
			MessageManager.fireStickLore = config.getString("Sticks.Fire Stick.Lore");
			FireStick.maxDurability = config.getInt("Sticks.Fire Stick.Durability");
			
			MessageManager.flightStickName = config.getString("Sticks.Flight Stick.Name");
			MessageManager.flightStickLore = config.getString("Sticks.Flight Stick.Lore");
			MessageManager.prefixFlightStickEnabled = config.getString("Sticks.Flight Stick.Flight Enabled");
			MessageManager.prefixFlightStickDisabled = config.getString("Sticks.Flight Stick.Flight Disabled");
			FlightStick.maxDurability = config.getInt("Sticks.Flight Stick.Durability");


			MessageManager.freezeStickName = config.getString("Sticks.Freeze Stick.Name");
			MessageManager.freezeStickLore = config.getString("Sticks.Freeze Stick.Lore");
			MessageManager.prefixFreezeStickEnabled = config.getString("Sticks.Freeze Stick.Freeze Enabled");
			MessageManager.prefixFreezeStickDisabled = config.getString("Sticks.Freeze Stick.Freeze Disabled");
			FreezeStick.maxDurability = config.getInt("Sticks.Freeze Stick.Durability");

			
			MessageManager.lightningStickName = config.getString("Sticks.Lightning Stick.Name");
			MessageManager.lightningStickLore = config.getString("Sticks.Lightning Stick.Lore");
			LightningStick.maxDurability = config.getInt("Sticks.Lightning Stick.Durability");

			
			MessageManager.enderStickName = config.getString("Sticks.Ender Stick.Name");
			MessageManager.enderStickLore = config.getString("Sticks.Ender Stick.Lore");
			EnderStick.maxDurability = config.getInt("Sticks.Ender Stick.Durability");

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
			MessageManager.prefixDontHavePerms = config.getString("Errors.Dont Have Permissions");
			MessageManager.prefixStickDoesNotExist = config.getString("Errors.Stick Doesnt Exist");
			MessageManager.prefixPlayerNotFound = config.getString("Errors.Player Not Found");
			MessageManager.prefixOreDoesNotExist = config.getString("Errors.Ore Doesnt Exist");

			
			//CONFIG
			EventManager.enderScope = config.getInt("Ender Stick Scope");
			EventManager.lightningScope = config.getInt("Lightning Stick Scope");
			
			Main.generationTime = config.getInt("Ores Generation Time");
			
			EventManager.glowingFireball = config.getBoolean("Set Glowing Fireball");
			EventManager.incendiaryFireball = config.getBoolean("Set Incendiary Fireball");
			EventManager.flightDurabilityTime = config.getInt("Flight Durability Time");
			EventManager.freezeDurabilityTime = config.getInt("Freeze Durability Time");
			EventManager.destroyIceTime = config.getInt("Destroy Ice Time");


			
			
	}
	
	public static void createConfigFile()
	{
		
        config.options().copyDefaults(true);
        plugin.saveDefaultConfig();


		
	}
	
}
