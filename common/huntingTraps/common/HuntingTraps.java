package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = HuntingTraps.ID, version = "0.3.0")
@NetworkMod(channels = { HuntingTraps.ID }, clientSideRequired=true,serverSideRequired=false) 

public class HuntingTraps
{
	public static final String ID = "Hunting Traps";
	public static final String VERSION = "0.3.0";

	@Instance(ID)
	public static HuntingTraps instance;
	
	//Blocks
	/*public static Block spikes;
	public static Block IPP;*/
	public static Block GPP;
	public static Block CageTrap;
	public static Block FireCage;
	public static Block Pitfall;
	public static Block IFireTrap;
	public static Block FakeGrass;
	public static Block FakeSand;
	public static Block InvisPrsrPlate;
	
	
	//Config
	public static int GPPID;
	public static int CageTID;
	public static int FireCageID;
	public static int PitfallID;
	public static int IFireTrapID;
	public static int FakeGrassID;
	public static int FakeSandID;
	public static int InvisPrsrPlateID;
	
	//Creative Tab
	public static CreativeTabs customTab = new CreativeTabHuntingTraps("Hunting Traps");
	
	@SidedProxy(clientSide="huntingTraps.client.HuntingTrapsClientProxy", serverSide="huntingTraps.client.HuntingTrapsCommonProxy")
	public static HuntingtrapsCommonProxy proxy;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event)
	{
		//Logger
			//logger = Logger.getLogger(ID);
			//logger.setParent(FMLLog.getLogger());
				
			//Configurations
			Configuration config = new Configuration(event.getSuggestedConfigurationFile());
			config.load();
			CageTID = config.getBlock("Cage Trap", 2001).getInt();
			FireCageID = config.getBlock("Fire Cage Trap", 2002).getInt();
			GPPID = config.getBlock("Grass Pressure Plate", 2003).getInt();
			PitfallID = config.getBlock("Pitfall Trap", 2004).getInt();
			IFireTrapID = config.getBlock("Incinerating Fire Trap", 2005).getInt();
			FakeGrassID = config.getBlock("Fake Grass Covering", 2006).getInt();
			FakeSandID = config.getBlock("Fake Sand Covering", 2007).getInt();
			InvisPrsrPlateID = config.getBlock("Invisible Pressure Plate", 2008).getInt();
            config.save();
	} 	 
	
		@Init
		public void Init(FMLInitializationEvent event)
		{
			//Properties
			//spikes = new BlockSSpikes(192, 4).setBlockName("spike");
			//IPP = new BlockInvisiblePP(193, 5, null, null).setBlockName("invisiblepp");
			GPP = new GPP(GPPID, EnumMobType.everything, Material.grass).setBlockName("GPP");
			CageTrap = new CageTrap(CageTID, 0, Material.rock).setBlockName("CageTrap");
			FireCage = new FireCage(FireCageID, 0, Material.rock).setBlockName("FireCage");
			Pitfall = new Pitfall(PitfallID, 0, Material.rock).setBlockName("Pitfall");
			IFireTrap = new IFireTrap(IFireTrapID, 0, Material.rock).setBlockName("IFireTrap");
			FakeGrass = new FakeGrass(FakeGrassID, 0, Material.ground).setBlockName("FakeGrass");
			FakeSand = new FakeSand(FakeSandID, 0, Material.ground).setBlockName("FakeSand");
			InvisPrsrPlate = new InvisPrsrPlate(InvisPrsrPlateID, EnumMobType.everything, Material.ground).setBlockName("InvisPrsrPlate");
			
			proxy.registerBlocks();
			
			//Game Registers
			/*GameRegistry.registerBlock(spikes, "Spikes");
			GameRegistry.registerBlock(IPP, "IPP");*/
			
			proxy.addNames();
			
			//Language Registers
			/*LanguageRegistry.addName(spikes, "Iron Spikes");
			LanguageRegistry.addName("IPP", "Invisible Pressure Plate");*/
						
			proxy.addRecipes();
			
			//Recipes
			/*GameRegistry.addRecipe(new ItemStack(CFT, 1), new Object[] { "IFI", "IRI", "ISI", 'I', Block.stone, 'F', Item.flint, 'S', Item.ingotIron, 'R', Item.redstone});
			GameRegistry.addRecipe(new ItemStack(spikes, 3), new Object[] { "   ", " I ", "III", 'I', Item.ingotIron });*/
			
			//Creative Tab
			LanguageRegistry.instance().addStringLocalization("Hunting Traps", "en_US", "Hunting Traps");
			GPP.setCreativeTab(HuntingTraps.customTab);
			CageTrap.setCreativeTab(HuntingTraps.customTab);
			FireCage.setCreativeTab(HuntingTraps.customTab);
			Pitfall.setCreativeTab(HuntingTraps.customTab);
			IFireTrap.setCreativeTab(HuntingTraps.customTab);
			FakeGrass.setCreativeTab(HuntingTraps.customTab);
			FakeSand.setCreativeTab(HuntingTraps.customTab);
			InvisPrsrPlate.setCreativeTab(HuntingTraps.customTab);
		}

	@PostInit
	public void afterLoaded(FMLPostInitializationEvent event){
		
	}
}