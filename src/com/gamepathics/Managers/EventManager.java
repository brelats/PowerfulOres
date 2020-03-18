package com.gamepathics.Managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.CraftingInventory;
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

	Player pl;
	static ArrayList<IOre> ores = new ArrayList<IOre>();
	static ArrayList<IStick> sticks = new ArrayList<IStick>();
	static boolean canFreeze = false;

	public EventManager() {
		sticks.add(new LightningStick());
		sticks.add(new FreezeStick());
		sticks.add(new FireStick());
		sticks.add(new FlightStick());
		sticks.add(new EnderStick());
	}

	 @EventHandler
	 public void onPlayerMove(PlayerMoveEvent x) 
	  {
		 Player player = x.getPlayer();
		  if(player.getInventory().getItemInHand().hasItemMeta())
		  {
			  if(player.getItemInHand().getItemMeta().getDisplayName().equals(MessageManager.freezeStickName))
			  {
				if(canFreeze)
				{
					
					
					for(int i = 0; i < 3; ++i) 
					{
						for(int j = 0; j < 3; ++j)
						{
							player.getWorld().getBlockAt(
									new Location(player.getWorld(),
											player.getLocation().getX() + i - 1,
											player.getLocation().getBlockY() - 1,
											player.getLocation().getZ() + j - 1)).setType(Material.ICE);
						}
					}
					
					
				}
				  
			  }
		  }

	  }
	 

	@EventHandler
	public void onPlayerEvents(PlayerInteractEvent x){
		pl = x.getPlayer();
		Location eye = pl.getEyeLocation();
		Location loc = eye.add(eye.getDirection().multiply(1.2));

		if (x.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			if(pl.getItemInHand().hasItemMeta()) {
			if (pl.getItemInHand().getItemMeta().getDisplayName().equals(MessageManager.lightningStickName)) 
			{
				pl.getWorld().strikeLightning(pl.getTargetBlock((Set<Material>)null, 25).getLocation());
				
			}
			else if (pl.getItemInHand().getItemMeta().getDisplayName().equals(MessageManager.fireStickName)) 
			{
				
				Fireball fireball = (Fireball) loc.getWorld().spawnEntity(loc, EntityType.FIREBALL);
				fireball.setVelocity(loc.getDirection().normalize().multiply(2));
				fireball.setShooter(pl);
				fireball.setIsIncendiary(true);
				
			} 
			else if (pl.getItemInHand().getItemMeta().getDisplayName().equals(MessageManager.freezeStickName)) 
			{
				canFreeze = !canFreeze;
				pl.sendMessage("" + canFreeze);
				
			}
			else if (pl.getItemInHand().getItemMeta().getDisplayName().equals(MessageManager.enderStickName))
			{
				pl.teleport(pl.getTargetBlock((Set<Material>)null, 30).getLocation());
			}
			else if(pl.getItemInHand().getItemMeta().getDisplayName().equals(MessageManager.flightStickName))
			{
				pl.setAllowFlight(!pl.getAllowFlight());	
						
						
			}
		}
			}

	}

	@EventHandler
	public void onCraftItem(PrepareItemCraftEvent event) {

		CraftingInventory inventory = event.getInventory();
		ItemStack[] items = inventory.getMatrix();

		checkCraftStick(event, items, MessageManager.lightningFragmentName);
		checkCraftStick(event, items, MessageManager.fireFragmentName);
		checkCraftStick(event, items, MessageManager.flightFragmentName);
		checkCraftStick(event, items, MessageManager.freezeFragmentName);
		checkCraftStick(event, items, MessageManager.enderFragmentName);

	}

	public void checkCraftStick(PrepareItemCraftEvent event, ItemStack[] items, String fragmentName) {
		if (items[0] == null && items[2] != null
				&& items[2].getItemMeta().getDisplayName().equalsIgnoreCase(fragmentName) && items[1] == null) {
			if (items[3] == null && items[4] != null
					&& items[4].getItemMeta().getDisplayName().equalsIgnoreCase(fragmentName) && items[5] == null) {
				if (items[7] == null && items[6] != null
						&& items[6].getItemMeta().getDisplayName().equalsIgnoreCase(fragmentName) && items[8] == null) {

					if(fragmentName.equalsIgnoreCase(MessageManager.lightningFragmentName))
					{
						LightningStick l = new LightningStick();
						event.getInventory().setResult(l.stickItem);

					}
					else if(fragmentName.equalsIgnoreCase(MessageManager.fireFragmentName))
					{
						
						FireStick fi = new FireStick();
						event.getInventory().setResult(fi.stickItem);

					}
					else if(fragmentName.equalsIgnoreCase(MessageManager.enderFragmentName))
					{
						EnderStick end = new EnderStick();
						event.getInventory().setResult(end.stickItem);
						
					}
					else if(fragmentName.equalsIgnoreCase(MessageManager.flightFragmentName))
					{
						FlightStick fli = new FlightStick();
						event.getInventory().setResult(fli.stickItem);
					}
					else if(fragmentName.equalsIgnoreCase(MessageManager.freezeFragmentName))
					{
						FreezeStick fre = new FreezeStick();
						event.getInventory().setResult(fre.stickItem);
					}

					}
				
				}
			}
		}
	
}
