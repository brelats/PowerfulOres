package com.gamepathics.Managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gamepathics.Interfaces.IOre;
import com.gamepathics.Ores.EnderOre;

public class EventManager implements Listener{


	static ArrayList<IOre> ores = new ArrayList<IOre>();
	
	
	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent e)
	{
		/*
		Player pl = e.getPlayer();
		if(e.getBlock().getType().equals(EnderOre.oreMaterial))
		{
			for(int i = 0; i < ores.size(); i++)
			{
				if(ores.get(i).getLocation().distance(e.getBlock().getLocation()) < 1.5f)
				{
		            e.getBlock().setType(Material.AIR);
					e.getBlock().getWorld().dropItemNaturally(ores.get(i).getLocation(), ores.get(i).getItemToDrop());

					ores.remove(i);
					break;
				}
			}		
		}*/
	
	}
	
	public static void generateOre(World w)
	{
		/*
        List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
		
		for(Player p : playerList)
		{
			EnderOre ore = new EnderOre();
			ore.setLocation(p.getLocation());
			ores.add(ore);
			w.getBlockAt(p.getLocation()).setType(ore.getOreMaterial());;
			
		}*/
		
		
	}
	
	
	
	
}
