package com.gamepathics.Interfaces;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public interface IOre {

	//Ore name
	public String getOreName();
	public void setOreName(String name);
	
	
	//Ore lore
	public String getOreLore();
	public void setOreLore(String lore);
	
	
	//Ore enchantment
	public Enchantment getEnchantment();
	public void setEnchantment(Enchantment enchantment);
	
	
	//Spawn probability
	public int getSpawnProbability();
	public void setSpawnProbability(int probability);
	
	
	//Item drop
	public ItemStack getItemToDrop();
	public void setItemToDrop(ItemStack item);
}
