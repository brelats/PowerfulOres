package com.gamepathics.Managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.gamepathics.Interfaces.IOre;
import com.gamepathics.Interfaces.IStick;
import com.gamepathics.Main.Main;
import com.gamepathics.Ores.EnderOre;
import com.gamepathics.Ores.LightningOre;
import com.gamepathics.Sticks.EnderStick;
import com.gamepathics.Sticks.FireStick;
import com.gamepathics.Sticks.FlightStick;
import com.gamepathics.Sticks.FreezeStick;
import com.gamepathics.Sticks.LightningStick;

import net.minecraft.server.v1_14_R1.PlayerInventory;

public class EventManager implements Listener {

	Main plugin = Main.getPlugin(Main.class);
	Player pl;
	static ArrayList<IOre> ores = new ArrayList<IOre>();
	static ArrayList<IStick> sticks = new ArrayList<IStick>();
	static HashMap<Player, FreezeStick> freezeSticks = new HashMap<Player, FreezeStick>();
	static HashMap<Player, FlightStick> flightSticks = new HashMap<Player, FlightStick>();
	static HashMap<Player, LightningStick> lightningSticks = new HashMap<Player, LightningStick>();
	static HashMap<Player, EnderStick> enderSticks = new HashMap<Player, EnderStick>();
	static HashMap<Player, FireStick> fireSticks = new HashMap<Player, FireStick>();

	static HashMap<Player, Integer> playerInteractCounter = new HashMap<Player, Integer>();
	public static ArrayList<BukkitTask> threads =  new ArrayList<BukkitTask>();
	
	//CONFIG
	public static int lightningScope = 30, enderScope = 30;
	public static int flightDurabilityTime = 1000;
	public static int freezeDurabilityTime = 1000;
	public static int destroyIceTime = 100;
	
	public static boolean incendiaryFireball = true, glowingFireball = true;

	public EventManager() {
		sticks.add(new LightningStick());
		sticks.add(new FreezeStick());
		sticks.add(new FireStick());
		sticks.add(new FlightStick());
		sticks.add(new EnderStick());
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent x) {
		Player player = x.getPlayer();

		if (player.getInventory().getItemInMainHand().hasItemMeta()) {
			if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
					.equals(MessageManager.freezeStickName)) {
				if (freezeSticks.get(player) != null) {
					if (freezeSticks.get(player).canFreeze) {
							generateIceFreezeStick(player, freezeSticks.get(player));

					} 

				}
			}

		}
	}

	@EventHandler
	public void OnPlayerChangeItem(PlayerItemHeldEvent e) {
		Player player = (Player) e.getPlayer();
		if (player.getInventory().getItemInMainHand().hasItemMeta()) {
			if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
					.equals(MessageManager.flightStickName)) {
				if (flightSticks.get(player) != null) {
					if (player.getGameMode().equals(GameMode.SURVIVAL)) {
						if (flightSticks.get(player).canFlight) {
							
						flightSticks.get(player).canFlight = false;
						player.setAllowFlight(false);
						player.sendMessage(MessageManager.flightStickDisabled);
						}
					}
				}
			}else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
					.equals(MessageManager.freezeStickName))
			{
				if (freezeSticks.get(player) != null) {
					if (freezeSticks.get(player).canFreeze) {

						freezeSticks.get(player).canFreeze = false;
						player.sendMessage(MessageManager.freezeStickDisabled);
					}
				}
			}

		}
	}

	@EventHandler
	public void onPlayerInteracts(PlayerInteractEvent x) {
		pl = x.getPlayer();
		Location eye = pl.getEyeLocation();
		Location loc = eye.add(eye.getDirection().multiply(1.2));

		if (x.getAction().equals(Action.RIGHT_CLICK_AIR) || x.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (x.getHand().equals(EquipmentSlot.HAND)) {

				if (pl.getInventory().getItemInMainHand().hasItemMeta()) {

/* Lightning */ 		if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equals(MessageManager.lightningStickName)) {

						if (lightningSticks.get(pl) == null) {
							lightningSticks.put(pl, new LightningStick());

						} else {
							if (lightningSticks.get(pl).durability > 0) {
								pl.getWorld().strikeLightning(
										pl.getTargetBlock((Set<Material>) null, lightningScope).getLocation());
								pl.spawnParticle(Particle.SPELL_WITCH, pl.getLocation(), 10);
								pl.getInventory().getItemInMainHand()
										.setItemMeta(lightningSticks.get(pl).substractDurability(1));
							} else if (lightningSticks.get(pl).durability <= 0){
							
								pl.getInventory().getItemInMainHand().setAmount(0);
								lightningSticks.remove(pl);
								}
						}

/* Fire */				} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
								.equals(MessageManager.fireStickName)) {
						if (fireSticks.get(pl) == null) {
							fireSticks.put(pl, new FireStick());

						} else {
							if (fireSticks.get(pl).durability > 0) {

								pl.spawnParticle(Particle.FLAME, pl.getLocation(), 10);
								Fireball fireball = (Fireball) loc.getWorld().spawnEntity(loc, EntityType.FIREBALL);
								fireball.setVelocity(loc.getDirection().normalize().multiply(2));
								fireball.setShooter(pl);
								fireball.setIsIncendiary(incendiaryFireball);
								fireball.setGlowing(glowingFireball);
								pl.getInventory().getItemInMainHand().setItemMeta(fireSticks.get(pl).substractDurability(1));

							} else if (fireSticks.get(pl).durability <= 0){
							
								pl.getInventory().getItemInMainHand().setAmount(0);
								fireSticks.remove(pl);
								}
						}

					

/* Freeze */ 			} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
								.equals(MessageManager.freezeStickName)) {
						if (freezeSticks.get(pl) == null) {
							freezeSticks.put(pl, new FreezeStick());
						}
						
							if (freezeSticks.get(pl).durability > 0) {

								freezeSticks.get(pl).canFreeze = !freezeSticks.get(pl).canFreeze;
								pl.spawnParticle(Particle.SNOW_SHOVEL, pl.getLocation(), 10);

								if (freezeSticks.get(pl).canFreeze) {
									pl.sendMessage(MessageManager.freezeStickEnabled);
									substractFreezeStickDurability(freezeDurabilityTime, freezeSticks.get(pl), pl);

								} else {
									pl.sendMessage(MessageManager.freezeStickDisabled);

								}
							} else if (freezeSticks.get(pl).durability <= 0){
							
								pl.getInventory().getItemInMainHand().setAmount(0);
								freezeSticks.remove(pl);
								}
						

/* Ender */ 			} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
								.equals(MessageManager.enderStickName)) {
						if (enderSticks.get(pl) == null) {
							enderSticks.put(pl, new EnderStick());
						} else {
							if (enderSticks.get(pl).durability > 0) {
						
						pl.getInventory().getItemInMainHand().setItemMeta(enderSticks.get(pl).substractDurability(1));
						pl.playSound(pl.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 50, 1);
						pl.teleport(pl.getTargetBlock((Set<Material>) null, enderScope).getLocation());
						pl.spawnParticle(Particle.PORTAL, pl.getLocation(), 10);
						}else if (enderSticks.get(pl).durability <= 0){
							
							pl.getInventory().getItemInMainHand().setAmount(0);
							enderSticks.remove(pl);
							}
						}
/* Flight */			} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equals(MessageManager.flightStickName)) {
	
	
						pl.spawnParticle(Particle.CLOUD, pl.getLocation(), 10);
						if (flightSticks.get(pl) == null) {
							flightSticks.put(pl, new FlightStick());
							
						}
							
							if (flightSticks.get(pl).durability > 0) {
						
								flightSticks.get(pl).canFlight = !flightSticks.get(pl).canFlight;
						
								if (flightSticks.get(pl).canFlight) {
									pl.sendMessage(MessageManager.flightStickEnabled);
									substractFlightStickDurability(flightDurabilityTime, flightSticks.get(pl), pl);


								} else {
									pl.sendMessage(MessageManager.flightStickDisabled);
							

								}
						pl.setAllowFlight(flightSticks.get(pl).canFlight);
						
						
					}else if (flightSticks.get(pl).durability <= 0){
						
						pl.getInventory().getItemInMainHand().setAmount(0);
						flightSticks.remove(pl);
						}
					
					}
					}
			}

		}
	}

	@EventHandler
	public void onCraftItem(PrepareItemCraftEvent event) {

		CraftingInventory inventory = event.getInventory();
		ItemStack[] items = inventory.getMatrix();
		Player player = (Player) event.getView().getPlayer();

		checkCraftStick(event, items, MessageManager.lightningFragmentName, player);
		checkCraftStick(event, items, MessageManager.fireFragmentName, player);
		checkCraftStick(event, items, MessageManager.flightFragmentName, player);
		checkCraftStick(event, items, MessageManager.freezeFragmentName, player);
		checkCraftStick(event, items, MessageManager.enderFragmentName, player);

	}

	public void checkCraftStick(PrepareItemCraftEvent event, ItemStack[] items, String fragmentName, Player pl) {
		if (items[0] == null && items[2] != null
				&& items[2].getItemMeta().getDisplayName().equalsIgnoreCase(fragmentName) && items[1] == null) {
			if (items[3] == null && items[4] != null
					&& items[4].getItemMeta().getDisplayName().equalsIgnoreCase(fragmentName) && items[5] == null) {
				if (items[7] == null && items[6] != null
						&& items[6].getItemMeta().getDisplayName().equalsIgnoreCase(fragmentName) && items[8] == null) {

					if (fragmentName.equalsIgnoreCase(MessageManager.lightningFragmentName)) {
						LightningStick l = new LightningStick();
						event.getInventory().setResult(l.stickItem);

					} else if (fragmentName.equalsIgnoreCase(MessageManager.fireFragmentName)) {

						FireStick fi = new FireStick();
						event.getInventory().setResult(fi.stickItem);

					} else if (fragmentName.equalsIgnoreCase(MessageManager.enderFragmentName)) {
						EnderStick end = new EnderStick();
						event.getInventory().setResult(end.stickItem);

					} else if (fragmentName.equalsIgnoreCase(MessageManager.flightFragmentName)) {
						FlightStick fli = new FlightStick();
						event.getInventory().setResult(fli.stickItem);
					} else if (fragmentName.equalsIgnoreCase(MessageManager.freezeFragmentName)) {
						FreezeStick fre = new FreezeStick();
						event.getInventory().setResult(fre.stickItem);
					}

				}

			}
		}
	}

	public void substractFlightStickDurability(int time, FlightStick stick, Player pl) {

		Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				while (stick.canFlight) {
					try {
						if (stick.durability > 0) {
							Thread.sleep((long) time);
							if (pl.getInventory().getItemInMainHand().hasItemMeta())
								if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
										.equalsIgnoreCase(MessageManager.flightStickName))
									pl.getInventory().getItemInMainHand().setItemMeta(stick.substractDurability(1));

						} else if (stick.durability <= 0) {
							pl.getInventory().getItemInMainHand().setAmount(0);
							pl.sendMessage(MessageManager.flightStickDisabled);
							pl.setAllowFlight(false);
							stick.canFlight = false;
							flightSticks.remove(pl);
							break;
						}
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				
			}
		});
		

	}
	
	public void generateIceFreezeStick(Player player, FreezeStick stick)
	{

		for (int i = 0; i < 3; ++i) {

			for (int j = 0; j < 3; ++j) {
				if (!player.getWorld()
						.getBlockAt(new Location(player.getWorld(), player.getLocation().getX() + i - 1,
								player.getLocation().getBlockY() - 1,
								player.getLocation().getZ() + j - 1))
						.getType().equals(Material.BEDROCK))
				{
					
					Block b = player.getWorld().getBlockAt(new Location(player.getWorld(),
							player.getLocation().getX() + i - 1, player.getLocation().getBlockY() - 1,
							player.getLocation().getZ() + j - 1));
						
					b.setType(Material.ICE);
					
					destroyIce(destroyIceTime, b);
				}
					
					
			}
		}
	}
	
	public void destroyIce(int time, Block block)
	{
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			@Override
			public void run()  
			{
				block.breakNaturally();

			}
			
		}, time);
		

	}
	
	
	public void substractFreezeStickDurability(int time, FreezeStick stick, Player pl) {

	Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				while (stick.canFreeze) {
					try {
						if (stick.durability > 0) {
							Thread.sleep((long) time);
							if (pl.getInventory().getItemInMainHand().hasItemMeta())
								if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
										.equalsIgnoreCase(MessageManager.freezeStickName))
									
									pl.getInventory().getItemInMainHand().setItemMeta(stick.substractDurability(1));

						} else if (stick.durability <= 0) {
							pl.getInventory().getItemInMainHand().setAmount(0);
							pl.sendMessage(MessageManager.freezeStickDisabled);
							stick.canFreeze = false;
							freezeSticks.remove(pl);
							break;
						}
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		});

	}

}
