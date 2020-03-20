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
	static HashMap<Player, Integer> playerInteractCounter = new HashMap<Player, Integer>();
	int lightningScope = 30, enderScope = 30;

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

						for (int i = 0; i < 3; ++i) {

							for (int j = 0; j < 3; ++j) {
								if (!player.getWorld()
										.getBlockAt(new Location(player.getWorld(), player.getLocation().getX() + i - 1,
												player.getLocation().getBlockY() - 1,
												player.getLocation().getZ() + j - 1))
										.getType().equals(Material.BEDROCK))
									player.getWorld().getBlockAt(new Location(player.getWorld(),
											player.getLocation().getX() + i - 1, player.getLocation().getBlockY() - 1,
											player.getLocation().getZ() + j - 1)).setType(Material.ICE);
							}
						}

					} else {
						freezeSticks.get(player).canFreeze = false;
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

						player.setAllowFlight(false);
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
					if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equals(MessageManager.lightningStickName)) {

						pl.getWorld()
								.strikeLightning(pl.getTargetBlock((Set<Material>) null, lightningScope).getLocation());
						pl.getInventory().getItemInMainHand().setDurability((short) 1);
						pl.spawnParticle(Particle.SPELL_WITCH, pl.getLocation(), 10);

					} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equals(MessageManager.fireStickName)) {

						pl.spawnParticle(Particle.FLAME, pl.getLocation(), 10);
						Fireball fireball = (Fireball) loc.getWorld().spawnEntity(loc, EntityType.FIREBALL);
						fireball.setVelocity(loc.getDirection().normalize().multiply(2));
						fireball.setShooter(pl);
						fireball.setIsIncendiary(true);
						fireball.setGlowing(true);
						pl.getInventory().getItemInMainHand()
								.setDurability((short) (pl.getInventory().getItemInMainHand().getDurability() - 1));

					} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equals(MessageManager.freezeStickName)) {
						if (freezeSticks.get(pl) == null)
							freezeSticks.put(pl, new FreezeStick());
						freezeSticks.get(pl).canFreeze = !freezeSticks.get(pl).canFreeze;
						pl.spawnParticle(Particle.SNOW_SHOVEL, pl.getLocation(), 10);

						if (FreezeStick.canFreeze) {
							pl.sendMessage(MessageManager.freezeStickEnabled);

						} else {
							pl.sendMessage(MessageManager.freezeStickDisabled);

						}

					} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equals(MessageManager.enderStickName)) {
						pl.playSound(pl.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 50, 1);
						
						pl.teleport(pl.getTargetBlock((Set<Material>) null, 30).getLocation());
						pl.getInventory().getItemInMainHand()
								.setDurability((short) (pl.getInventory().getItemInMainHand().getDurability() - 1));
						pl.spawnParticle(Particle.PORTAL, pl.getLocation(), 10);
					} else if (pl.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
							.equals(MessageManager.flightStickName)) {
						pl.spawnParticle(Particle.CLOUD, pl.getLocation(), 10);
						if (flightSticks.get(pl) == null)
							flightSticks.put(pl, new FlightStick());
						flightSticks.get(pl).canFlight = !flightSticks.get(pl).canFlight;
						pl.setAllowFlight(!pl.getAllowFlight());
						if (pl.getAllowFlight()) {
							pl.sendMessage(MessageManager.flightStickEnabled);

						} else {
							pl.sendMessage(MessageManager.flightStickDisabled);
						}

						delayStickEvents(200, flightSticks.get(pl), pl);

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

	public void delayStickEvents(int time, FlightStick stick, Player pl) {
		Bukkit.getServer().getScheduler().runTask(plugin, new Runnable() {

			@Override
			public void run() {

				while (stick.canFlight) {
					try {
						Thread.sleep(time);
						if (stick.getStick().getDurability() <= 0) {
							pl.setAllowFlight(false);
							pl.getInventory().getItemInMainHand().setType(Material.AIR);
							break;
						}

						stick.getStick().setDurability((short) (stick.getStick().getDurability() - 1));

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
	}

}
