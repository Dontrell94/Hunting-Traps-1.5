package huntingTraps.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class Pitfall extends Block
{
	int b = 1;
	
	public Pitfall(int i, int j, Material rock)
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
	
	public int idDropped(int i, Random random)
	{
		return HuntingTraps.PitfallID;
	}
	
	 public void onNeighborBlockChange(World world, int i, int j, int k, int l)
     {
             if(world.isBlockGettingPowered(i, j, k))
             {
                    world.setBlockWithNotify(i, j, k, 0);
         			world.setBlockWithNotify(i, j, k - 1, 0);
         			world.setBlockWithNotify(i, j, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j, k, 0);
         			world.setBlockWithNotify(i + 1, j, k, 0);
         			world.setBlockWithNotify(i - 1, j, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j, k - 1, 0);
         			world.setBlockWithNotify(i + 1, j, k + 1, 0);
         			world.setBlockWithNotify(i + 1, j, k - 1, 0);
         			world.setBlockWithNotify(i, j - 1, k, 0);
         			world.setBlockWithNotify(i, j - 1, k - 1, 0);
         			world.setBlockWithNotify(i, j - 1, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j - 1, k, 0);
         			world.setBlockWithNotify(i + 1, j - 1, k, 0);
         			world.setBlockWithNotify(i - 1, j - 1, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j - 1, k - 1, 0);
         			world.setBlockWithNotify(i + 1, j - 1, k + 1, 0);
         			world.setBlockWithNotify(i + 1, j - 1, k - 1, 0);
         			world.setBlockWithNotify(i, j - 2, k, 0);
         			world.setBlockWithNotify(i, j - 2, k - 1, 0);
         			world.setBlockWithNotify(i, j - 2, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j - 2, k, 0);
         			world.setBlockWithNotify(i + 1, j - 2, k, 0);
         			world.setBlockWithNotify(i - 1, j - 2, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j - 2, k - 1, 0);
         			world.setBlockWithNotify(i + 1, j - 2, k + 1, 0);
         			world.setBlockWithNotify(i + 1, j - 2, k - 1, 0);
         			world.setBlockWithNotify(i, j - 3, k, 0);
         			world.setBlockWithNotify(i, j - 3, k - 1, 0);
         			world.setBlockWithNotify(i, j - 3, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j - 3, k, 0);
         			world.setBlockWithNotify(i + 1, j - 3, k, 0);
         			world.setBlockWithNotify(i - 1, j - 3, k + 1, 0);
         			world.setBlockWithNotify(i - 1, j - 3, k - 1, 0);
         			world.setBlockWithNotify(i + 1, j - 3, k + 1, 0);
         			world.setBlockWithNotify(i + 1, j - 3, k - 1, 0);
         			if (this.b == 1)
        			{
         				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("! - A mob has triggered a Pit Fall Trap nearby.");
        			}
             }
     }
}