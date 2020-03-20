package com.gamepathics.Main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Log.Level;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import com.gamepathics.Managers.CommandList;
import com.gamepathics.Managers.CommandManager;
import com.gamepathics.Managers.ConfigManager;
import com.gamepathics.Managers.EventManager;
import com.gamepathics.Managers.MessageManager;
import com.gamepathics.Managers.WorldManager;
import com.gamepathics.Sticks.StickEnchantment;


public class Main extends JavaPlugin{
	
	public static StickEnchantment stickEnchantment;
	
	@Override
	public void onEnable() 
	{
		File configFile;
		configFile = new File(getDataFolder(), "config.yml");
		
		if(!configFile.exists())
			ConfigManager.createConfigFile();
		else
			ConfigManager.loadConfigFile();	

		
		NamespacedKey key = new NamespacedKey(this, "powerfulores");
		stickEnchantment = new StickEnchantment(key);
		
		this.getCommand(CommandList.mainCommand).setExecutor((CommandExecutor) new CommandManager());
		this.getServer().getPluginManager().registerEvents(new EventManager(), this);
		this.getServer().getPluginManager().registerEvents(new WorldManager(), this);		
	
		
		
		//1800 s = 30 min
		//36000 ticks = 1800 * 20
		generateOres(36000, 36000);  
		registerEnchants(stickEnchantment);
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

	private void registerEnchants(Enchantment ench){
	    try{
	        try {
	            Field f = Enchantment.class.getDeclaredField("acceptingNew");
	            f.setAccessible(true);
	            f.set(null, true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        try {
	            Enchantment.registerEnchantment(ench);
	            System.out.println("Registered enchantment "+ench.getName()+" with id "+ench.getKey()+"!");
	        } catch (IllegalArgumentException e){
	            //if this is thrown it means the id is already taken.
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	public void loadDefaultConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	

}
