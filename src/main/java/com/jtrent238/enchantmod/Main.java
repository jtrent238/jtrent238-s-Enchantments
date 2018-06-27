package com.jtrent238.enchantmod;

import java.util.ArrayList;

import com.jtrent238.enchantmod.enchantments.EnchantBullseye;
import com.jtrent238.enchantmod.enchantments.EnchantCharmed;
import com.jtrent238.enchantmod.enchantments.EnchantDeflection;
import com.jtrent238.enchantmod.enchantments.EnchantDrawback;
import com.jtrent238.enchantmod.enchantments.EnchantEndurance;
import com.jtrent238.enchantmod.enchantments.EnchantEntanglement;
import com.jtrent238.enchantmod.enchantments.EnchantFamine;
import com.jtrent238.enchantmod.enchantments.EnchantHardened;
import com.jtrent238.enchantmod.enchantments.EnchantHarvester;
import com.jtrent238.enchantmod.enchantments.EnchantJumping;
import com.jtrent238.enchantmod.enchantments.EnchantLightweight;
import com.jtrent238.enchantmod.enchantments.EnchantPoisonResistance;
import com.jtrent238.enchantmod.enchantments.EnchantRampart;
import com.jtrent238.enchantmod.enchantments.EnchantRange;
import com.jtrent238.enchantmod.enchantments.EnchantSlowness;
import com.jtrent238.enchantmod.enchantments.EnchantStrike;
import com.jtrent238.enchantmod.common.CommonProxy;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.command.ICommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;


@Mod(modid=Main.MODID, name=Main.MODNAME, version=(Main.MODVERSION)/*, dependencies="required-after:jtrent238core@[" + YouTubers.COREVERSION + "]"*/)
//@MeddleMod(id=Main.MODID, name=Main.MODNAME, version=(Main.MODVERSION), author=Main.MODAUTHOR)
public class Main 
{

	
	@SidedProxy(clientSide="com.jtrent238.enchantmod.client.ClientProxy", serverSide="com.jtrent238.enchantmod.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	public static final String MODID = "jtrent238enchantments";

	@Instance(MODID)
    public static Main instance;

	public static final String CATEGORY_ENCHANTMENT_IDS = "Enchantment Ids";
	
	private static int PoisonResistanceID = 64;
	private static int RampartID = 65;
	private static int StrikeID = 66;
	private static int HarvesterID = 67;
	private static int DeflectionID = 68;
	private static int LightweightID = 69;
	private static int EnduranceID = 70;
	private static int DrawbackID = 71;
	private static int RangeID = 72;
	private static int SlownessID = 73;
	private static int EntanglementID = 74;
	private static int HardenedID = 75;
	private static int FamineID = 76;
	private static int CharmedID = 77;
	private static int JumpingID = 78;
	private static int BullseyeID = 79;
	
	
	public static final String MODVERSION = "1.0.0.0";
	public final static String COREVERSION = "1.0.0.3";
	public static final String MODNAME = "jtrent238's Enchantments Mod";
	public static final String MODAUTHOR = "jtrent238";
	public static final String MC = "1.7.10";

	
	@ForgeSubscribe(priority = EventPriority.NORMAL)
    public void eventHandler(RenderGameOverlayEvent event) {

	}
		
@Mod.EventHandler
public void preInit(FMLPreInitializationEvent event)
{
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	event.getModConfigurationDirectory();
	event.getModConfigurationDirectory();
	event.getModLog();
	event.getModMetadata();
	event.getModState();
	event.getSide();
	event.getVersionProperties();
	
	
	config.load();
	config.getLoadedConfigVersion();
	
	PoisonResistanceID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "PoisonResistance", 64, 255, 0, "Set ID");
	RampartID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Rampart", 65, 255, 0, "Set ID");
	StrikeID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Strike", 66, 255, 0, "Set ID");
	HarvesterID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Harvester", 67, 255, 0, "Set ID");
	DeflectionID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Deflection", 68, 255, 0, "Set ID");
	LightweightID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Lightweight", 69, 255, 0, "Set ID");
	EnduranceID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Endurance", 70, 255, 0, "Set ID");
	DrawbackID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Drawback", 71, 255, 0, "Set ID");
	RangeID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Range", 72, 255, 0, "Set ID");
	SlownessID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Slowness", 73, 255, 0, "Set ID");
	EntanglementID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Entanglement", 74, 255, 0, "Set ID");
	HardenedID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Hardened", 75, 255, 0, "Set ID");
	FamineID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Famine", 76, 255, 0, "Set ID");
	CharmedID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Charmed", 77, 255, 0, "Set ID");
	JumpingID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Jumping", 78, 255, 0, "Set ID");
	BullseyeID = config.getInt(CATEGORY_ENCHANTMENT_IDS, "Bullseye", 79, 255, 0, "Set ID");

}

public static final Enchantment PoisonResistance = new EnchantPoisonResistance(PoisonResistanceID, 22, EnumEnchantmentType.armor);
public static final Enchantment Rampart = new EnchantRampart(RampartID, 22, EnumEnchantmentType.weapon);
public static final Enchantment Strike = new EnchantStrike(StrikeID, 22, EnumEnchantmentType.weapon);
public static final Enchantment Harvester = new EnchantHarvester(HarvesterID, 22, EnumEnchantmentType.digger);
public static final Enchantment Deflection = new EnchantDeflection(DeflectionID, 22, EnumEnchantmentType.armor_torso);
public static final Enchantment Lightweight = new EnchantLightweight(LightweightID, 22, EnumEnchantmentType.armor_legs);
public static final Enchantment Endurance = new EnchantEndurance(EnduranceID, 22, EnumEnchantmentType.armor_torso);
public static final Enchantment Drawback = new EnchantDrawback(DrawbackID, 22, EnumEnchantmentType.bow);
public static final Enchantment Range = new EnchantRange(RangeID, 22, EnumEnchantmentType.bow);
public static final Enchantment Slowness = new EnchantSlowness(SlownessID, 22, EnumEnchantmentType.bow);
public static final Enchantment Entanglement = new EnchantEntanglement(EntanglementID, 22, EnumEnchantmentType.bow);
public static final Enchantment Hardened = new EnchantHardened(HardenedID, 22, EnumEnchantmentType.armor);
public static final Enchantment Famine = new EnchantFamine(FamineID, 22, EnumEnchantmentType.bow);
public static final Enchantment Charmed = new EnchantCharmed(CharmedID, 22, EnumEnchantmentType.weapon);
public static final Enchantment Jumping = new EnchantJumping(JumpingID, 22, EnumEnchantmentType.armor_feet);
public static final Enchantment Bullseye = new EnchantBullseye(BullseyeID, 22, EnumEnchantmentType.bow);

@Mod.EventHandler
public void init(FMLInitializationEvent event)
{
	proxy.init(event);
	
}


@Mod.EventHandler
public void postInit(FMLPostInitializationEvent event) {
	{
		
	    
	}
}
				
}