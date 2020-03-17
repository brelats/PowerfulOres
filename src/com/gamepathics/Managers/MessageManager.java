package com.gamepathics.Managers;

public class MessageManager {

	//Messages Prefix
	public static final String powerfulOresPrefix = "[PowerfulOres] ";

	//Ore Gived
	public static final String oreGived = " gived to ";
	
	//Errors
	public static final String oreDoesNotExist = "This ore does not exist";
	public static final String playerNotFound = "Player not found. Please check the inserted name.";

	public static String commandNotFound = "Please use /(powerfulores | po) give (ore | stick) (ore type | stick type)";
	
	//Help
	public static final String helpCommand = "§3==============================================\n"
										   + "§3||                           §aPOWERFUL ORES                     §3||\n"
										   + "==============================================\n"
										   + "§b/powerfulores help §3- plugin commands\n"
										   + "§b/powerfulores orelist §3- get a list of all ores\n"
										   + "§b/powerfulores sticklist §3- get a list of all sticks\n"
										   + "§b/powerfulores give ore [ore name] [player] §3- get a specified ore\n"
										   + "§b/powerfulores give stick [stick name] [player]§3- get a specified stick\n";


	
	// LightningStick
	public static  String lightningStickName = "Lightning Stick";
	public static  String lightningStickLore = "[RightClick] Feel the power of the Lightning God!";
	
	// FireStick
	public static  String fireStickName = "Fire Stick";
	public static  String fireStickLore = "[RightClick] Feel the power of the Fire God!";
	
	// EnderStick
	public static  String enderStickName = "Ender Stick";
	public static  String enderStickLore = "[RightClick] Feel the power of the Ender God!";

	// FlightStick
	public static  String flightStickName = "Flight Stick";
	public static  String flightStickLore = "[RightClick] Feel the power of the Wind God!";

	// FreezeStick
	public static  String freezeStickName = "Freeze Stick";
	public static  String freezeStickLore = "[RightClick] Feel the power of the Ice God!";


	
	
	//EnderOre
	public static final String enderOreName = "Ender Ore";
		//EnderFragment
		public static  String enderFragmentName = "Ender Fragment";
		public static  String enderFragmentLore = "Use this to craft EnderStick";
	
	//FireOre
	public static final String fireOreName = "Fire Ore";
		//FireFragment
		public static  String fireFragmentName = "Fire Fragment";
		public static  String fireFragmentLore = "Use this to craft FireStick";
	
	//FlightOre
	public static final String flightOreName = "Flight Ore";
		//FlightFragment
		public static  String flightFragmentName = "Flight Fragment";
		public static  String flightFragmentLore = "Use this to craft FlightStick";
	
	//FrezeOre
	public static final String freezeOreName = "Freeze Ore";
		//FreezeFragment
		public static  String freezeFragmentName = "Freeze Fragment";
		public static  String freezeFragmentLore = "Use this to craft FreezeStick";
	
	//LightningOre
	public static final String lightningOreName = "Lightning Ore";
		//LightningFragment
		public static  String lightningFragmentName = "Lightning Fragment";
		public static String lightningFragmentLore = "Use this to craft LightningStick";
}
