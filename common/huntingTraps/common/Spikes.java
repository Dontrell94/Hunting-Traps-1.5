package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Spikes extends Block
{
	public Spikes(int par1, int j)
	{
		super(par1, Material.iron);
	}
	
	public String getTextureFile()
	{
		return "/huntingTraps/textures/hnttrp.png";
	}
	
	/*@Override
	public int getBlockTextureFromSide(int j)
	{
		return 14;
	}*/
	
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.attackEntityFrom(DamageSource.generic, 6);
		
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public int getRenderType()
    {
        return 1;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
}
