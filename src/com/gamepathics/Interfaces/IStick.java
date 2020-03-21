package com.gamepathics.Interfaces;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public interface IStick {
	
	
	//Stick name
	public String getStickName();
	public void setStickName(String name);
	
	
	//Stick Lore
	public String getStickLore();
	public void setStickLore(String Lore);
	
	
	//Stick Enchantments
	public Enchantment getEnchantment();
	public void setEnchantment(Enchantment enchantment);
	
	
	
	//Stick Permissions
	public String getPermission();
	public void setPermission(String Permission);
	

	public void setPlayer(Player pl);

	
	public ItemStack getStick();
	public ItemStack setStick();
	
	
	public ItemMeta substractDurability(int k) ;

}
