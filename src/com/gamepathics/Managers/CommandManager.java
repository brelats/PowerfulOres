package com.gamepathics.Managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamepathics.Ores.EnderOre;

//Gestor de comandos
public class CommandManager implements CommandExecutor
{

	EnderOre enderOre = new EnderOre();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdString, String[] args) {
		
		if(sender instanceof Player)
		{
			
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase(CommandList.mainCommand))
			{
				
				player.getInventory().addItem(enderOre.getOre());
				return true;
			}
	
		}
		
			
		return true;
	}

	
	
}
