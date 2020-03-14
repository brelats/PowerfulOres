package com.gamepathics.Managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//Gestor de comandos
public class CommandsManager implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdString, String[] args) {
		
		if(sender instanceof Player)
		{
			
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase(CommandsList.mainCommand))
			{
				
				player.sendMessage("Hello World");
				return true;
			}
	
		}
		
			
		return true;
	}

	
	
}
