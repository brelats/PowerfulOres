package com.gamepathics.Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import com.gamepathics.Interfaces.IOre;
import com.gamepathics.Main.Main;
import com.gamepathics.Ores.EnderOre;
import com.gamepathics.Ores.FireOre;
import com.gamepathics.Ores.FlightOre;
import com.gamepathics.Ores.FreezeOre;
import com.gamepathics.Ores.LightningOre;

public class WorldManager implements Listener {

	static Main plugin = Main.getPlugin(Main.class);

	static ArrayList<IOre> oresGenerated = new ArrayList<IOre>();
	static ArrayList<IOre> allOres = new ArrayList<IOre>();

	static int oreCount = 0;

	static private File oresFile = new File(plugin.getDataFolder(), "ores.yml");
	static private FileConfiguration file = YamlConfiguration.loadConfiguration(oresFile);

	public WorldManager() {

		allOres.add(new EnderOre());
		allOres.add(new FireOre());
		allOres.add(new FlightOre());
		allOres.add(new FreezeOre());
		allOres.add(new LightningOre());
		loadOres();
	}

	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent e) {

		Player pl = e.getPlayer();

		for (IOre ore : allOres) {
			if (e.getBlock().getType().toString().contains(ore.getOre().getType().toString())) {
				for (int i = 0; i < oresGenerated.size(); i++) {
					if (oresGenerated.get(i).getLocation().distance(e.getBlock().getLocation()) < 1.5f) {
						if(pl.hasPermission(MessageManager.permOreBreak)) {
						e.setDropItems(false);
						e.getBlock().getWorld().dropItemNaturally(oresGenerated.get(i).getLocation(),
								oresGenerated.get(i).getItemToDrop());
						oresGenerated.remove(i);
						saveOres();
						break;
						}else {
							e.setCancelled(true);
							dontHavePerms(e.getPlayer());
							break;
						}
					}
				}
			}
		}

	}
	
	@EventHandler
	public void OnPlaceBlock(BlockPlaceEvent e)
	{
		if(e.getItemInHand().hasItemMeta())
		{
			for (IOre ore : allOres) {
				if(e.getItemInHand().getItemMeta().getDisplayName().equals(ore.getOreName()))
				{
					if(e.getPlayer().hasPermission(MessageManager.permOrePlace)) {
					IOre newOre = null;
					
					switch (ore.getOreName()) {
					case MessageManager.enderOreName:
						newOre = new EnderOre();
						break;
					case MessageManager.flightOreName:
						newOre = new FlightOre();
						break;
					case MessageManager.freezeOreName:
						newOre = new FreezeOre();
						break;	
					case MessageManager.fireOreName:
						newOre = new FireOre();
						break;
					case MessageManager.lightningOreName:
						newOre = new LightningOre();
						break;
					}
					
					newOre.setLocation(e.getBlockPlaced().getLocation());

					oresGenerated.add(newOre);
					saveOres();
				}else {
					e.setCancelled(true);
					dontHavePerms(e.getPlayer());
				}
			}
			}
		}
		
	}

	public static void generateOre(World w) {

		int maxBlocks = 400;
		int minBlocks = 40;

		List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());

		for (Player p : playerList) {

			int randomChoise = new Random().nextInt(5);
			IOre ore = null;

			switch (randomChoise) {
			case 0:
				ore = new EnderOre();
				break;
			case 1:
				ore = new FireOre();
				break;
			case 2:
				ore = new FlightOre();
				break;
			case 3:
				ore = new FreezeOre();
				break;
			case 4:
				ore = new LightningOre();
				break;  

			default:
				break;
			}

			int randomX = new Random().nextInt(maxBlocks - minBlocks + 1) + minBlocks;
			int randomZ = new Random().nextInt(maxBlocks - minBlocks + 1) + minBlocks;

			double orePosX = p.getLocation().getX() + randomX;
			double orePosZ = p.getLocation().getZ() + randomZ;

			Location spawnLoc = new Location(w, orePosX, 5, orePosZ);
			oreCount++;

			p.sendMessage(ore.getOreName() + " :LocX: " + orePosX + " :LocY: " + 5 + " :LocZ: " + orePosZ);
			ore.setLocation(spawnLoc);
			oresGenerated.add(ore);
			w.getBlockAt(spawnLoc).setType(ore.getOreMaterial());

			saveOres();
			

		}

	}

	public static void saveOres() 
	{
		int counter = 0;
		Map<String, Object> configValues = file.getValues(false);

		for (Map.Entry<String, Object> entry : configValues.entrySet()) {
		    file.set(entry.getKey(), null);
			saveData(file, oresFile);
		}
		
		for(IOre ore : oresGenerated)
		{
			counter++;
			file.set(counter + "." + ore.getOreName(), ore.getLocation());
		}
		
		oreCount = counter;
		
		saveData(file, oresFile);
		
	}

	public static void loadOres() 
	{

		int counter = 1;

		while (file.getString(counter + "." + MessageManager.fireOreName) != null
				|| file.getString(counter + "." + MessageManager.flightOreName) != null
				|| file.getString(counter + "." + MessageManager.freezeOreName) != null
				|| file.getString(counter + "." + MessageManager.enderOreName) != null
				|| file.getString(counter + "." + MessageManager.lightningOreName) != null) 
		{
			
			if (file.getString(counter + "." + MessageManager.fireOreName) != null) 
			{
				FireOre ore = new FireOre();
				Location spawnLoc = (Location) file.get(counter + "." + MessageManager.fireOreName);
				
				ore.setLocation(spawnLoc);
				oresGenerated.add(ore);
				Bukkit.getWorlds().get(0).getBlockAt(spawnLoc).setType(ore.getOreMaterial());

			} 
			else if (file.getString(counter + "." + MessageManager.flightOreName) != null) 
			{
				FlightOre ore = new FlightOre();
				Location spawnLoc = (Location) file.get(counter + "." + MessageManager.flightOreName);
				
				ore.setLocation(spawnLoc);
				oresGenerated.add(ore);
				Bukkit.getWorlds().get(0).getBlockAt(spawnLoc).setType(ore.getOreMaterial());
			} 
			else if (file.getString(counter + "." + MessageManager.freezeOreName) != null) 
			{
				FreezeOre ore = new FreezeOre();
				Location spawnLoc = (Location) file.get(counter + "." + MessageManager.freezeOreName);
				
				ore.setLocation(spawnLoc);
				oresGenerated.add(ore);
				Bukkit.getWorlds().get(0).getBlockAt(spawnLoc).setType(ore.getOreMaterial());
			} 
			else if (file.getString(counter + "." + MessageManager.enderOreName) != null) 
			{
				EnderOre ore = new EnderOre();
				Location spawnLoc = (Location) file.get(counter + "." + MessageManager.enderOreName);
				
				ore.setLocation(spawnLoc);

				oresGenerated.add(ore);
				Bukkit.getWorlds().get(0).getBlockAt(spawnLoc).setType(ore.getOreMaterial());
			} 
			else if (file.getString(counter + "." + MessageManager.lightningOreName) != null) 
			{
				
				LightningOre ore = new LightningOre();
				Location spawnLoc = (Location) file.get(counter + "." + MessageManager.lightningOreName);
				
				ore.setLocation(spawnLoc);

				oresGenerated.add(ore);
				Bukkit.getWorlds().get(0).getBlockAt(spawnLoc).setType(ore.getOreMaterial());
			}

			counter++;
		}
		
		oreCount = counter;

	}

	public static void saveData(FileConfiguration ymlConfig, File ymlFile) {
		try {
			ymlConfig.save(ymlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dontHavePerms(Player player) {
		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.dontHavePerms);

	}

}
