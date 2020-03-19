package com.gamepathics.Managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamepathics.Interfaces.IOre;
import com.gamepathics.Interfaces.IStick;
import com.gamepathics.Ores.EnderOre;
import com.gamepathics.Ores.FireOre;
import com.gamepathics.Ores.FlightOre;
import com.gamepathics.Ores.FreezeOre;
import com.gamepathics.Ores.LightningOre;
import com.gamepathics.Sticks.EnderStick;
import com.gamepathics.Sticks.FireStick;
import com.gamepathics.Sticks.FlightStick;
import com.gamepathics.Sticks.FreezeStick;
import com.gamepathics.Sticks.LightningStick;

//Gestor de comandos
public class CommandManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdString, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission(MessageManager.permHelpCommand)) {
				if (cmd.getName().equalsIgnoreCase(CommandList.mainCommand)) {
					if (args.length > 0) {
						if (args[0].equalsIgnoreCase(CommandList.giveCommand)) {
							if (player.hasPermission(MessageManager.permGiveCommand)) {
								if (args.length > 1) {
									if (args[1].equalsIgnoreCase(CommandList.oreCommand)) {
										if (args.length > 2) {
											if (args.length > 3) {
												if (Bukkit.getServer().getPlayer(args[3]) != null) {
													Player otherPlayer = Bukkit.getServer().getPlayer(args[3]);
													giveOre(args, player, otherPlayer);
													return true;
												} else {
													playerNotFound(player);
													return true;
												}

											}
											giveOre(args, player, player);
											return true;
										} else {
											commandNotFound(player);
											return true;
										}

									} else if (args[1].equalsIgnoreCase(CommandList.stickCommand)) {
										if (args.length > 2) {
											if (args.length > 3) {
												if (Bukkit.getServer().getPlayer(args[3]) != null) {
													Player otherPlayer = Bukkit.getServer().getPlayer(args[3]);
													giveStick(args, player, otherPlayer);
													return true;
												} else {
													playerNotFound(player);
													return true;
												}

											}
											giveStick(args, player, player);
											return true;
										} else {
											commandNotFound(player);
											return true;
										}

									} else {
										commandNotFound(player);
										return true;
									}

								} else {
									commandNotFound(player);
									return true;
								}

							} else {
								dontHavePerms(player);
								return true;
							}
						}

						else if (args[0].equalsIgnoreCase(CommandList.helpCommand)) {
							helpCommand(player);
						} else if (player.hasPermission(MessageManager.permListCommand)) {
							if (args[0].equalsIgnoreCase(CommandList.oreListCommand)) {
								oreListCommand(player);
							} else if (args[0].equalsIgnoreCase(CommandList.stickListCommand)) {
								stickListCommand(player);
							} else {
								commandNotFound(player);
								return true;
							}

						} else {
							dontHavePerms(player);
							return true;
						}

					} else {
						helpCommand(player);
						return true;
					}
				} else {
					helpCommand(player);
					return true;
				}

				return true;
			} else {
				dontHavePerms(player);
			}
		}

		return true;
	}

	public boolean giveOre(String[] args, Player player, Player otherPlayer) {
		switch (args[2].toLowerCase()) {

		case CommandList.enderOre:

			EnderOre o = new EnderOre();
			otherPlayer.getInventory().addItem(o.getOre());
			player.sendMessage(MessageManager.powerfulOresPrefix + o.getOreName() + MessageManager.oreGived
					+ otherPlayer.getName());
			return true;

		case CommandList.freezeOre:

			FreezeOre f = new FreezeOre();
			otherPlayer.getInventory().addItem(f.getOre());
			player.sendMessage(MessageManager.powerfulOresPrefix + f.getOreName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;

		case CommandList.flightOre:

			FlightOre fl = new FlightOre();
			otherPlayer.getInventory().addItem(fl.getOre());
			player.sendMessage(MessageManager.powerfulOresPrefix + fl.getOreName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;

		case CommandList.fireOre:

			FireOre fi = new FireOre();
			otherPlayer.getInventory().addItem(fi.getOre());
			player.sendMessage(MessageManager.powerfulOresPrefix + fi.getOreName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;

		case CommandList.lightningOre:

			LightningOre l = new LightningOre();
			otherPlayer.getInventory().addItem(l.getOre());
			player.sendMessage(MessageManager.powerfulOresPrefix + l.getOreName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;
		}

		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.oreDoesNotExist);
		return false;
	}

	public boolean giveStick(String[] args, Player player, Player otherPlayer) {
		switch (args[2].toLowerCase()) {

		case CommandList.enderStick:

			EnderStick o = new EnderStick();
			otherPlayer.getInventory().addItem(o.getStick());
			player.sendMessage(MessageManager.powerfulOresPrefix + o.getStickName() + MessageManager.oreGived
					+ otherPlayer.getName());
			return true;

		case CommandList.freezeStick:

			FreezeStick f = new FreezeStick();
			otherPlayer.getInventory().addItem(f.getStick());
			player.sendMessage(MessageManager.powerfulOresPrefix + f.getStickName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;

		case CommandList.flightStick:

			FlightStick fl = new FlightStick();
			otherPlayer.getInventory().addItem(fl.getStick());
			player.sendMessage(MessageManager.powerfulOresPrefix + fl.getStickName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;

		case CommandList.fireStick:

			FireStick fi = new FireStick();
			otherPlayer.getInventory().addItem(fi.getStick());
			player.sendMessage(MessageManager.powerfulOresPrefix + fi.getStickName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;

		case CommandList.lightningStick:

			LightningStick l = new LightningStick();
			otherPlayer.getInventory().addItem(l.getStick());
			player.sendMessage(MessageManager.powerfulOresPrefix + l.getStickName() + MessageManager.oreGived
					+ otherPlayer.getName());

			return true;
		}

		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.stickDoesNotExist);
		return false;
	}

	public void commandNotFound(Player player) {
		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.commandNotFound);
	}

	public void helpCommand(Player player) {
		player.sendMessage(MessageManager.helpCommand);
	}

	public void oreListCommand(Player player) {
		player.sendMessage(MessageManager.oreListCommand);
	}

	public void stickListCommand(Player player) {
		player.sendMessage(MessageManager.stickListCommand);
	}

	public void playerNotFound(Player player) {
		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.playerNotFound);

	}

	public void dontHavePerms(Player player) {
		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.dontHavePerms);

	}

}
