package com.gamepathics.Interfaces;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public interface IOre {

	public ItemStack getOre();
	public void setOre(ItemStack ore);
	
	//Ore name
	public String getOreName();
	public void setOreName(String name);
	
	
	//Ore material
	public Material getOreMaterial();
	public void setOreMaterial(Material material);
		
	
	//Spawn probability
	public int getSpawnProbability();
	public void setSpawnProbability(int probability);
	
	
	//Item drop
	public ItemStack getItemToDrop();
	public void setItemToDrop(ItemStack item);
	
	
	//Item permissions
	public String getPermission();
	public void setPermission(String permision);
	
	
	//Ore Location
	public Location getLocation();
	public void setLocation(Location location);
	
}
