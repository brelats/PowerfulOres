package com.gamepathics.Sticks;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.gamepathics.Interfaces.IStick;
import com.gamepathics.Managers.MessageManager;

public class FireStick implements IStick{

	public ItemStack stickItem = new ItemStack(Material.STICK);
	public ShapedRecipe stickRecipe = new ShapedRecipe(stickItem);
	
	
	String stickName = MessageManager.fireStickName;
	String stickLore = MessageManager.fireStickLore;
	String permission = "";
	Enchantment stickEnchantment = Enchantment.QUICK_CHARGE;
	
	
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
	public void Hability() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayer(Player pl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShapedRecipe recipe() {
		
		return null;
	}

	@Override
	public ItemStack getStick() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack setStick() {
		// TODO Auto-generated method stub
		return null;
	}
}
