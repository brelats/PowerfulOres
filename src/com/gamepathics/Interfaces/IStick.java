package com.gamepathics.Interfaces;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

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
	
	
	
	//Stick Hability
	public void Hability();


	
	public void setPlayer(Player pl);


}
