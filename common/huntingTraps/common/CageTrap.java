package huntingTraps.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class CageTrap extends Block
{
	int b = 1;
	
	public CageTrap(int i, int j, Material ground)
	{
		super(i, Material.ground);
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
             if(world.isBlockGettingPowered(i, j, k))
             {
                     int block = Block.fenceIron.blockID;
	                        
	                world.setBlockWithNotify(i, j + 1, k - 1, block);
	    			world.setBlockWithNotify(i, j + 2, k - 1, block);
	    			world.setBlockWithNotify(i, j + 1, k + 1, block);
	    			world.setBlockWithNotify(i, j + 2, k + 1, block);
	    			world.setBlockWithNotify(i + 1, j + 1, k, block);
	    			world.setBlockWithNotify(i + 1, j + 2, k, block);
	    			world.setBlockWithNotify(i - 1, j + 1, k, block);
	    			world.setBlockWithNotify(i - 1, j + 2, k, block);
	    			world.setBlockWithNotify(i, j, k, block);
	    			
	    			world.setBlockWithNotify(i + 1, j + 1, k - 1, block);
	    			world.setBlockWithNotify(i + 1, j + 2, k - 1, block);
	    			
	    			world.setBlockWithNotify(i - 1, j + 1, k - 1, block);
	    			world.setBlockWithNotify(i - 1, j + 2, k - 1, block);
	    			
	    			world.setBlockWithNotify(i - 1, j + 1, k + 1, block);
	    			world.setBlockWithNotify(i - 1, j + 2, k + 1, block);
	    			
	    			world.setBlockWithNotify(i + 1, j + 1, k + 1, block);
	    			world.setBlockWithNotify(i + 1, j + 2, k + 1, block);
	    			
	    			if (this.b == 1)
	    			{
	    				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("! - A mob has triggered a Cage Trap nearby.");
	    			}
             	}
     		else
    		{
    			world.setBlockWithNotify(i, j + 1, k - 1, 0);
    			world.setBlockWithNotify(i, j + 2, k - 1, 0);
    			world.setBlockWithNotify(i, j + 1, k + 1, 0);
    			world.setBlockWithNotify(i, j + 2, k + 1, 0);
    			world.setBlockWithNotify(i + 1, j + 1, k, 0);
    			world.setBlockWithNotify(i + 1, j + 2, k, 0);
    			world.setBlockWithNotify(i - 1, j + 1, k, 0);
    			world.setBlockWithNotify(i - 1, j + 2, k, 0);
    		}
            
     }
}