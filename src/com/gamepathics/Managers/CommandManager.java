package com.gamepathics.Managers;

import java.util.ArrayList;
import java.util.List;

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

//Gestor de comandos
public class CommandManager implements CommandExecutor 
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdString, String[] args) 
	{

		if (sender instanceof Player) 
		{
			Player player = (Player) sender;

			if (cmd.getName().equalsIgnoreCase(CommandList.mainCommand)) 
			{
				if (args.length > 0) 
				{
					if (args[0].equalsIgnoreCase(CommandList.giveCommand)) 
					{
						if (args.length > 1) 
						{
							if (args[1].equalsIgnoreCase(CommandList.oreCommand)) 
							{
								if (args.length > 2) 
								{
									giveOre(args, player);
									return true;
								}
								else 
								{
									commandNotFound(player);
									return true;
								}

							}
							else 
							{
								commandNotFound(player);
								return true;
							}

						}
						else 
						{
							commandNotFound(player);
							return true;
						}
					} 
					else 
					{
						commandNotFound(player);
						return true;
					}

				}

				return true;
			}

		}

		return true;
	}

	public boolean giveOre(String[] args, Player player) 
	{
		switch (args[2].toLowerCase()) 
		{

		case CommandList.enderOre:

			EnderOre o = new EnderOre();
			player.getInventory().addItem(o.getOre());
			player.sendMessage(
					MessageManager.powerfulOresPrefix + o.getOreName() + MessageManager.oreGived + player.getName());
			return true;

		case CommandList.freezeOre:

			FreezeOre f = new FreezeOre();
			player.getInventory().addItem(f.getOre());
			player.sendMessage(
					MessageManager.powerfulOresPrefix + f.getOreName() + MessageManager.oreGived + player.getName());

			return true;

		case CommandList.flightOre:

			FlightOre fl = new FlightOre();
			player.getInventory().addItem(fl.getOre());
			player.sendMessage(
					MessageManager.powerfulOresPrefix + fl.getOreName() + MessageManager.oreGived + player.getName());

			return true;

		case CommandList.fireOre:

			FireOre fi = new FireOre();
			player.getInventory().addItem(fi.getOre());
			player.sendMessage(
					MessageManager.powerfulOresPrefix + fi.getOreName() + MessageManager.oreGived + player.getName());

			return true;

		case CommandList.lightningOre:

			LightningOre l = new LightningOre();
			player.getInventory().addItem(l.getOre());
			player.sendMessage(
					MessageManager.powerfulOresPrefix + l.getOreName() + MessageManager.oreGived + player.getName());

			return true;
		}

		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.oreDoesNotExist);
		return false;
	}

	public void commandNotFound(Player player) 
	{
		player.sendMessage(MessageManager.powerfulOresPrefix + MessageManager.commandNotFound);
	}

}
