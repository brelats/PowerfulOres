package com.gamepathics.Managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gamepathics.Interfaces.IOre;
import com.gamepathics.Ores.EnderOre;
import com.gamepathics.Ores.FireOre;
import com.gamepathics.Ores.FlightOre;
import com.gamepathics.Ores.FreezeOre;
import com.gamepathics.Ores.LightningOre;

public class WorldManager implements Listener{

	static ArrayList<IOre> oresGenerated = new ArrayList<IOre>();
	static ArrayList<IOre> allOres = new ArrayList<IOre>();
	
	public WorldManager()
	{
		allOres.add(new EnderOre());
		allOres.add(new FireOre());
		allOres.add(new FlightOre());
		allOres.add(new FreezeOre());
		allOres.add(new LightningOre());	
	}
	
	
	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent e)
	{
		
		Player pl = e.getPlayer();
		
		for(IOre ore : allOres)
		{
			if(e.getBlock().getType().toString().contains(ore.getOre().getType().toString())) 
			{
				for(int i = 0; i < oresGenerated.size(); i++)
				{
					if(oresGenerated.get(i).getLocation().distance(e.getBlock().getLocation()) < 1.5f)
					{
			            e.getBlock().setType(Material.AIR);
						e.getBlock().getWorld().dropItemNaturally(oresGenerated.get(i).getLocation(), oresGenerated.get(i).getItemToDrop());

						oresGenerated.remove(i);
						break;
					}
				}		
			}
		}
		
	
	}
	
	public static void generateOre(World w)
	{
		
		int maxBlocks = 400;
		int minBlocks = 40;
		
        List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
		

		for(Player p : playerList)
		{

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
	        p.sendMessage(ore.getOreName() +  " :LocX: " + orePosX + " :LocY: " + 5 + " :LocZ: " + orePosZ);
			ore.setLocation(spawnLoc);
			oresGenerated.add(ore);
			w.getBlockAt(spawnLoc).setType(ore.getOreMaterial());;
			
		}
		
		
	}
	
	
	
}
