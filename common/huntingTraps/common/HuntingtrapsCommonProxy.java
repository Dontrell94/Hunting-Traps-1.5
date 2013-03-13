package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class HuntingtrapsCommonProxy
{
	public void registerRenders() //Client side texture registering
	{
		
	}
	
	public void registerBlocks()
	{
		//For registering Blocks
		GameRegistry.registerBlock(HuntingTraps.GPP, "GPP");
		GameRegistry.registerBlock(HuntingTraps.CageTrap, "CageTrap");
		GameRegistry.registerBlock(HuntingTraps.FireCage, "FireCage");
		GameRegistry.registerBlock(HuntingTraps.Pitfall, "Pitfall");
		GameRegistry.registerBlock(HuntingTraps.IFireTrap, "IFireTrap");
		GameRegistry.registerBlock(HuntingTraps.FakeGrass, "FakeGrass");
		GameRegistry.registerBlock(HuntingTraps.FakeSand, "FakeSand");
		GameRegistry.registerBlock(HuntingTraps.InvisPrsrPlate, "InvisPrsrPlate");
		GameRegistry.registerBlock(HuntingTraps.Spikes, "Spikes");
	}
	
	public void addNames()
	{
		//For adding Item's ingame names
		LanguageRegistry.addName(HuntingTraps.GPP, "Grass Camoflauge Pressure Plate");
		LanguageRegistry.addName(HuntingTraps.CageTrap, "Cage Trap");
		LanguageRegistry.addName(HuntingTraps.FireCage, "Fire Cage");
		LanguageRegistry.addName(HuntingTraps.Pitfall, "Pitfall Trap");
		LanguageRegistry.addName(HuntingTraps.IFireTrap, "Incinerating Fire Trap");
		LanguageRegistry.addName(HuntingTraps.FakeGrass, "Fake Grass Covering");
		LanguageRegistry.addName(HuntingTraps.FakeSand, "Fake Sand Covering");
		LanguageRegistry.addName(HuntingTraps.InvisPrsrPlate, "Invisible Pressure Plate");
		LanguageRegistry.addName(HuntingTraps.Spikes, "Spikes");
	}
	
	public void addRecipes()
	{
		//For adding your Item's recipes
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.GPP, 1), new Object[] {"RRR", "GPG", "GGG", 'R', Item.seeds, 'G', Block.dirt, 'P', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.CageTrap, 1), new Object[] {"III", "IRI", "III", 'R', Item.redstone, 'I', Block.fenceIron});
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.FireCage, 1), new Object[] {"IFI", "IRI", "ISI", 'I', Block.stone, 'F', Item.flint, 'S', Item.ingotIron, 'R', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.Pitfall, 1), new Object[] {"SGS", "IRI", "SGS", 'S', Block.stone, 'G', Item.gunpowder, 'I', Item.ingotIron, 'R', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.IFireTrap, 1), new Object[] { "ISI", "IRI", "IXI", 'S', Item.flintAndSteel, 'I', Block.stone, 'R', Item.redstone, 'X', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.FakeGrass, 3), new Object[] { "SSS", "DDD", 'S', Item.seeds, 'D', Block.dirt });
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.FakeSand, 3), new Object[] { "SSS", "DDD", 'S', Block.sand, 'D', Block.sandStone });
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.InvisPrsrPlate, 1), new Object[] { "RGR", "GPG", "RGR", 'R', Item.redstone, 'G', Block.thinGlass, 'P', Block.stone });
		GameRegistry.addRecipe(new ItemStack(HuntingTraps.Spikes, 3), new Object[] { "   ", " I ", "III", 'I', Item.ingotIron });
	}
}