package com.gamepathics.Sticks;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.gamepathics.Interfaces.IStick;
import com.gamepathics.Main.Main;
import com.gamepathics.Managers.MessageManager;
import com.gamepathics.Ores.FireOre;
import com.gamepathics.Ores.LightningOre;

public class FireStick implements IStick{

	Plugin plugin = Main.getPlugin(Main.class);
	
	public ItemStack stickItem = new ItemStack(Material.STICK);
	
	
	ItemMeta stickMeta = stickItem.getItemMeta();
	
	
	String stickName = MessageManager.fireStickName;
	String stickLore = MessageManager.fireStickLore;
	String permission = "";
	Enchantment stickEnchantment;
	
	
	public FireStick() {
		
		ArrayList<String> loreList = new ArrayList<String>();
		loreList.add(stickLore);
		stickItem.setDurability((short)100);
		stickMeta.addEnchant(Main.stickEnchantment, 1, true);
		stickMeta.setDisplayName(stickName);
		stickMeta.setLore(loreList);
		stickItem.setItemMeta(stickMeta);

	}
	
	@Override
	public String getStickName() {
		// TODO Auto-generated method stub
		return stickName;
	}

	@Override
	public void setStickName(String name) {
		// TODO Auto-generated method stub
		stickName = name; 
	}

	@Override
	public String getStickLore() {
		// TODO Auto-generated method stub
		return stickLore;
	}

	@Override
	public void setStickLore(String lore) {
		// TODO Auto-generated method stub
		stickLore = lore;
	}

	@Override
	public Enchantment getEnchantment() {
		// TODO Auto-generated method stub
		return stickEnchantment;
	}

	@Override
	public void setEnchantment(Enchantment enchantment) {
		// TODO Auto-generated method stub
		stickEnchantment = enchantment;
	}

	@Override
	public String getPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPermission(String Permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayer(Player pl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack getStick() {
		// TODO Auto-generated method stub
		return stickItem;
	}

	@Override
	public ItemStack setStick() {
		// TODO Auto-generated method stub
		return null;
	}
}
