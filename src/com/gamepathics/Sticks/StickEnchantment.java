package com.gamepathics.Sticks;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;


public class StickEnchantment extends Enchantment {

	String name;
	int startLevel;
	
	public StickEnchantment(NamespacedKey key) {
		super(key);


		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMaxLevel() {

		return 0;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "PowerfulOres";
	}
	


	@Override
	public int getStartLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public boolean isCursed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTreasure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canEnchantItem(ItemStack item) {
		return item.getType() == Material.STICK;
	}

	@Override
	public boolean conflictsWith(Enchantment other) {
		return other == Enchantment.DIG_SPEED;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		// TODO Auto-generated method stub
		return EnchantmentTarget.ALL;
	}
	
}
