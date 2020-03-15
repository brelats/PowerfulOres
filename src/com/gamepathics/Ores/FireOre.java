package com.gamepathics.Ores;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gamepathics.Interfaces.IOre;
import com.gamepathics.Managers.MessageManager;

public class FireOre implements IOre {


	//String
	String oreName = MessageManager.fireOreName;
	String fragmentName = MessageManager.fireFragmentName;
	String fragmentLore = MessageManager.fireFragmentLore;
	
	
	//Material
	public static Material oreMaterial = Material.REDSTONE_ORE;
	public static Material fragmentMaterial = Material.STICK;
	
	//ItemStack
	ItemStack ore = new ItemStack(oreMaterial, 1);
	ItemStack fragment = new ItemStack(fragmentMaterial, 1);
	
	//ItemMeta
	ItemMeta fragmentMeta = fragment.getItemMeta();
	
	//Location
	Location oreLocation;
	

	public FireOre()
	{
		fragmentMeta.setDisplayName(fragmentName);
		fragmentMeta.setLore(Arrays.asList((fragmentLore)));
		fragment.setItemMeta(fragmentMeta);
	}
	
	@Override
	public String getOreName() {
		return oreName;
	}

	@Override
	public void setOreName(String name) {
		
		oreName = name;
	}


	@Override
	public int getSpawnProbability() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSpawnProbability(int probability) {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemStack getItemToDrop() {
		// TODO Auto-generated method stub
		return fragment;
	}

	@Override
	public void setItemToDrop(ItemStack item) {
		// TODO Auto-generated method stub
		fragment = item;
	}

	@Override
	public Material getOreMaterial() {

		return oreMaterial;
	}

	@Override
	public void setOreMaterial(Material material) {

		oreMaterial = material;
		
	}

	@Override
	public String getPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPermission(String permision) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location getLocation() {

		return oreLocation;
	}

	@Override
	public void setLocation(Location location) {
		
		oreLocation = location;		
	}

	@Override
	public ItemStack getOre() {
		// TODO Auto-generated method stub

		return ore;
	}

	@Override
	public void setOre(ItemStack ore) {
		this.ore = ore;
		
	}

}
