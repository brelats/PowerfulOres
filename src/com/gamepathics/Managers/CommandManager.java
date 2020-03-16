package com.gamepathics.Managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamepathics.Ores.EnderOre;
import com.gamepathics.Ores.FireOre;
import com.gamepathics.Ores.FlightOre;
import com.gamepathics.Ores.FreezeOre;
import com.gamepathics.Ores.LightningOre;

//Gestor de comandos
public class CommandManager implements CommandExecutor
{

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdString, String[] args) {
		
		if(sender instanceof Player)
		{
			
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase(CommandList.mainCommand))
			{
				EnderOre e = new EnderOre();
				FreezeOre f = new FreezeOre();
				FireOre fi = new FireOre();
				LightningOre l = new LightningOre();
				FlightOre fl = new FlightOre();
				
				player.getInventory().addItem(e.getItemToDrop());
				player.getInventory().addItem(f.getItemToDrop());
				player.getInventory().addItem(fi.getItemToDrop());
				player.getInventory().addItem(l.getItemToDrop());
				player.getInventory().addItem(fl.getItemToDrop());

				return true;
			}
	
		}
		
			
		return true;
	}

	
	
}
