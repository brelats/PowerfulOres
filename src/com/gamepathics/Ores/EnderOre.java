package com.gamepathics.Ores;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gamepathics.Interfaces.IOre;

public class EnderOre implements IOre {

	Material enderOreMaterial = Material.EMERALD_ORE;
	
	ItemStack enderOre = new ItemStack(enderOreMaterial, 1);
	
	Location enderOreLocation;
	
	
	@Override
	public String getOreName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOreName(String name) {
		// TODO Auto-generated method stub

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
		return null;
	}

	@Override
	public void setItemToDrop(ItemStack item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Material getOreMaterial() {

		return enderOreMaterial;
	}

	@Override
	public void setOreMaterial(Material material) {

		enderOreMaterial = material;
		
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

		return enderOreLocation;
	}

	@Override
	public void setLocation(Location location) {
		
		enderOreLocation = location;		
	}

}
