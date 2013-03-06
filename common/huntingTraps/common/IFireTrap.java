package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class IFireTrap extends Block
{
	int b = 1;
	
	public IFireTrap(int i, int j)
	{
		super(i, Material.rock);
	}
	
	public int getBlockTexturefromSide(int k)
	{
		switch(k)
		{
			case 0: return 4;
			case 1: return 6;
			default: return 5;
		}
	}
	/*
	 * 0 is bottom
	 * 1 is top
	 */
	
	 public void onNeighborBlockChange(World world, int i, int j, int k, int l)
     {
             if(world.isBlockIndirectlyGettingPowered(i, j, k))
             {
            	int block = Block.fire.blockID;
            	
     			world.setBlockWithNotify(i, j + 1, k, block);
     		 }
             else
     		{
     			world.setBlockWithNotify(i, j + 1, k, 0);
     		}
     }
}
