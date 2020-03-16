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
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import com.gamepathics.Interfaces.IOre;
import com.gamepathics.Interfaces.IStick;
import com.gamepathics.Ores.EnderOre;
import com.gamepathics.Ores.LightningOre;
import com.gamepathics.Sticks.EnderStick;
import com.gamepathics.Sticks.FireStick;
import com.gamepathics.Sticks.FlightStick;
import com.gamepathics.Sticks.FreezeStick;
import com.gamepathics.Sticks.LightningStick;

public class EventManager implements Listener {

	static ArrayList<IOre> ores = new ArrayList<IOre>();
	static ArrayList<IStick> sticks = new ArrayList<IStick>();

	public EventManager() {
		sticks.add(new LightningStick());
		sticks.add(new FreezeStick());
		sticks.add(new FireStick());
		sticks.add(new FlightStick());
		sticks.add(new EnderStick());
	}

	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent e) {
		/*
		 * Player pl = e.getPlayer();
		 * if(e.getBlock().getType().equals(EnderOre.oreMaterial)) { for(int i = 0; i <
		 * ores.size(); i++) {
		 * if(ores.get(i).getLocation().distance(e.getBlock().getLocation()) < 1.5f) {
		 * e.getBlock().setType(Material.AIR);
		 * e.getBlock().getWorld().dropItemNaturally(ores.get(i).getLocation(),
		 * ores.get(i).getItemToDrop());
		 * 
		 * ores.remove(i); break; } } }
		 */

	}

	public static void generateOre(World w) {
		/*
		 * List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
		 * 
		 * for(Player p : playerList) { EnderOre ore = new EnderOre();
		 * ore.setLocation(p.getLocation()); ores.add(ore);
		 * w.getBlockAt(p.getLocation()).setType(ore.getOreMaterial());;
		 * 
		 * }
		 */

	}

	@EventHandler
	public void onCraftItem(PrepareItemCraftEvent e) {
		
		HumanEntity human = e.getView().getPlayer();
		int c = 0;
		if (human instanceof Player) {
		
		if (e.getInventory().getType().equals(InventoryType.WORKBENCH)) {
			if(e.getRecipe() != null) {

				for (ItemStack item : e.getInventory().getMatrix()) {
		
			}
			}
		
		}
		}
	}

}
