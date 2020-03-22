package com.gamepathics.Managers;

public class MessageManager {

	//Messages Prefix
	public static final String powerfulOresPrefix = "§a[PowerfulOres] §3";

	//Ore Gived
	public static final String oreGived = " §3gived to ";
	
	//Errors
	public static  String prefixOreDoesNotExist = "This ore does not exist";
	public static  String oreDoesNotExist = powerfulOresPrefix + prefixOreDoesNotExist;
	
	public static  String prefixStickDoesNotExist = "This stick does not exist";
	public static String stickDoesNotExist = powerfulOresPrefix + prefixStickDoesNotExist;
	
	public static String prefixPlayerNotFound = "Player not found. Please check the inserted name.";
	public static String playerNotFound = powerfulOresPrefix + prefixPlayerNotFound;
	
	public static  String prefixDontHavePerms = "You don't have permission to do this.";
	public static  String dontHavePerms = powerfulOresPrefix + prefixDontHavePerms;

	//Permissions
	public static final String permHelpCommand = "powerfulores.commands";
	public static final String permGiveCommand = "powerfulores.command.give";
	public static final String permListCommand = "powerfulores.command.lists";
	
	public static final String permOreBreak = "powerfulores.ore.break";
	public static final String permOrePlace = "powerfulores.ore.place";
	
	public static final String permCraftFreezeStick = "powerfulores.craft.freeze";
	public static final String permCraftFireStick = "powerfulores.craft.fire";
	public static final String permCraftLightningStick = "powerfulores.craft.lightning";
	public static final String permCraftEnderStick = "powerfulores.craft.ender";
	public static final String permCraftFlightStick = "powerfulores.craft.flight";
	
	public static final String permUseFreezeStick = "powerfulores.use.freeze";
	public static final String permUseFireStick = "powerfulores.use.fire";
	public static final String permUseLightningStick = "powerfulores.use.lightning";
	public static final String permUseEnderStick = "powerfulores.use.ender";
	public static final String permUseFlightStick = "powerfulores.use.flight";
	

	
	
	//Help
	public static final String helpCommand = "§3==============================================\n"
										   + "§3||                           §aPOWERFUL ORES                     §3||\n"
										   + "==============================================\n"
										   + "§b/powerfulores help §3- plugin commands\n"
										   + "§b/powerfulores orelist §3- get a list of all ores\n"
										   + "§b/powerfulores sticklist §3- get a list of all sticks\n"
										   + "§b/powerfulores give ore [ore name] [player] §3- get a specified ore\n"
										   + "§b/powerfulores give stick [stick name] [player]§3- get a specified stick\n";

	
	public static String commandNotFound = helpCommand;

	public static String oreListCommand = "§3==============================================\n"
										+ "§3||                           §aORE  LIST                            §3||\n"
									   + "==============================================\n"
									   + "§b/powerfulores give ore lightning [player] §3- give a lightning ore\n"
									   + "§b/powerfulores give ore freeze [player] §3- give a freeze ore\n"
									   + "§b/powerfulores give ore flight [player] §3- give a flight ore\n"
									   + "§b/powerfulores give ore ender [player] §3- give a ender ore\n"
									   + "§b/powerfulores give ore fire [player] §3- give a ender ore\n";
	
	
	public static String stickListCommand   = "§3==============================================\n"
											+ "§3||                           §aSTICK  LIST                         §3||\n"
										    + "==============================================\n"
										    + "§b/powerfulores give stick lightning [player] §3- give a lightning stick\n"
										    + "§b/powerfulores give stick freeze [player] §3- give a freeze stick\n"
										    + "§b/powerfulores give stick flight [player] §3- give a flight stick\n"
										    + "§b/powerfulores give stick ender [player] §3- give a ender stick\n"
										    + "§b/powerfulores give stick fire [player] §3- give a ender stick\n";

							
	
	// LightningStick
	public static  String lightningStickName = "§bLightning Stick";
	public static  String lightningStickLore = "[RightClick] Feel the power of the Lightning God!";
	
	// FireStick
	public static  String fireStickName = "§cFire Stick";
	public static  String fireStickLore = "[RightClick] Feel the power of the Fire God!";
	
	// EnderStick
	public static  String enderStickName = "§2Ender Stick";
	public static  String enderStickLore = "[RightClick] Feel the power of the Ender God!";

	// FlightStick
	public static  String flightStickName = "§8Flight Stick";
	public static  String flightStickLore = "[RightClick] Feel the power of the Wind God!";
	
	public static String prefixFlightStickEnabled = "Flight Enabled";
	public static  String flightStickEnabled = powerfulOresPrefix + prefixFlightStickEnabled;
	
	public static String prefixFlightStickDisabled = "§cFlight Disabled";
	public static String flightStickDisabled = powerfulOresPrefix + prefixFlightStickDisabled;

	// FreezeStick
	public static  String freezeStickName = "§9Freeze Stick";
	public static  String freezeStickLore = "[RightClick] Feel the power of the Ice God!";
	
	public static  String prefixFreezeStickEnabled = "Freeze Enabled";
	public static  String freezeStickEnabled = powerfulOresPrefix + prefixFreezeStickEnabled;
	
	public static  String prefixFreezeStickDisabled = "§cFreeze Disabled";
	public static  String freezeStickDisabled =  powerfulOresPrefix + prefixFreezeStickDisabled;




	//EnderOre
	public static final String enderOreName = "§2Ender Ore";
		//EnderFragment
		public static  String enderFragmentName = "§2Ender Fragment";
		public static  String enderFragmentLore = "Use this to craft Ender Stick";
	
	//FireOre
	public static final String fireOreName = "§cFire Ore";
		//FireFragment
		public static  String fireFragmentName = "§cFire Fragment";
		public static  String fireFragmentLore = "Use this to craft Fire Stick";
	
	//FlightOre
	public static final String flightOreName = "§8Flight Ore";
		//FlightFragment
		public static  String flightFragmentName = "§8Flight Fragment";
		public static  String flightFragmentLore = "Use this to craft Flight Stick";
	
	//FrezeOre
	public static final String freezeOreName = "§9Freeze Ore";
		//FreezeFragment
		public static  String freezeFragmentName = "§9Freeze Fragment";
		public static  String freezeFragmentLore = "Use this to craft Freeze Stick";
	
	//LightningOre
	public static final String lightningOreName = "§bLightning Ore";
		//LightningFragment
		public static  String lightningFragmentName = "§bLightning Fragment";
		public static String lightningFragmentLore = "Use this to craft Lightning Stick";
}
