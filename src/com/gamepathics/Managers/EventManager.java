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
	public void onCraftItem(PrepareItemCraftEvent event) {

		CraftingInventory inventory = event.getInventory();
		ItemStack[] items = inventory.getMatrix();

		if (items[0] == null && items[2] != null && items[2].getItemMeta().getDisplayName().equalsIgnoreCase(MessageManager.lightningFragmentName) && items[1] == null) 
		{
			if (items[3] == null && items[4] != null && items[4].getItemMeta().getDisplayName().equalsIgnoreCase(MessageManager.lightningFragmentName) && items[5] == null) 
			{
				if (items[7] == null && items[6] != null && items[6].getItemMeta().getDisplayName().equalsIgnoreCase(MessageManager.lightningFragmentName) && items[8] == null) 
				{
					System.out.println(items[2].getItemMeta().getDisplayName());
					System.out.println(MessageManager.lightningFragmentName);
					LightningStick l = new LightningStick();
					event.getInventory().setResult(l.stickItem);
				}
			}
		}

	}

}
