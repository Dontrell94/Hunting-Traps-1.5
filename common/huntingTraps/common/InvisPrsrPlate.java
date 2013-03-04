package huntingTraps.common;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class InvisPrsrPlate extends Block
{
	private EnumMobType triggerMobType;

    protected InvisPrsrPlate(int par1, EnumMobType par3EnumMobType, Material par4Material)
    {
        super(par1, par4Material);
        this.triggerMobType = par3EnumMobType;
        this.setTickRandomly(true);
        float var5 = 0.0625F;
        this.setBlockBounds(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
    }

    public int tickRate()
    {
        return 10;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)par3 + this.maxY, (double)par4 + this.maxZ);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return true;
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) || BlockFence.isIdAFence(par1World.getBlockId(par2, par3 - 1, par4));
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        boolean var6 = false;

        if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && !BlockFence.isIdAFence(par1World.getBlockId(par2, par3 - 1, par4)))
        {
            var6 = true;
        }

        if (var6)
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockMetadata(par2, par3, par4) != 0)
            {
                this.setStateIfMobInteractsWithPlate(par1World, par2, par3, par4);
            }
        }
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockMetadata(par2, par3, par4) != 1)
            {
                this.setStateIfMobInteractsWithPlate(par1World, par2, par3, par4);
            }
        }
    }

    private void setStateIfMobInteractsWithPlate(World par1World, int par2, int par3, int par4)
    {
        boolean var5 = par1World.getBlockMetadata(par2, par3, par4) == 1;
        boolean var6 = false;
        float var7 = 0.125F;
        List<?> var8 = null;

        if (this.triggerMobType == EnumMobType.everything)
        {
            var8 = par1World.getEntitiesWithinAABBExcludingEntity((Entity)null, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)((float)par2 + var7), (double)par3, (double)((float)par4 + var7), (double)((float)(par2 + 1) - var7), (double)par3 + 0.25D, (double)((float)(par4 + 1) - var7)));
        }

        if (this.triggerMobType == EnumMobType.mobs)
        {
            var8 = par1World.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)((float)par2 + var7), (double)par3, (double)((float)par4 + var7), (double)((float)(par2 + 1) - var7), (double)par3 + 0.25D, (double)((float)(par4 + 1) - var7)));
        }

        if (this.triggerMobType == EnumMobType.players)
        {
            var8 = par1World.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)((float)par2 + var7), (double)par3, (double)((float)par4 + var7), (double)((float)(par2 + 1) - var7), (double)par3 + 0.25D, (double)((float)(par4 + 1) - var7)));
        }

        if (!var8.isEmpty())
        {
            Iterator<?> var9 = var8.iterator();

            while (var9.hasNext())
            {
                Entity var10 = (Entity)var9.next();

                if (!var10.doesEntityNotTriggerPressurePlate())
                {
                    var6 = true;
                    break;
                }
            }
        }

        if (var6 && !var5)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
            par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.1D, (double)par4 + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!var6 && var5)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
            par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.1D, (double)par4 + 0.5D, "random.click", 0.3F, 0.5F);
        }

        if (var6)
        {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
        }
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (par6 > 0)
        {
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    //bounds
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        boolean var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 1;

        if (var5)
        {
            this.setBlockBounds(1.0F, 0.0F, 1.0F, 0.0F, 0.03125F, 0.0F);
        }
        else
        {
            this.setBlockBounds(1.0F, 0.0F, 1.0F, 0.0F, 0.0625F, 0.0F);
        }
    }

    public boolean isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return par1IBlockAccess.getBlockMetadata(par2, par3, par4) > 0;
    }

    public boolean isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 0 ? false : par5 == 1;
    }

    public boolean canProvidePower()
    {
        return true;
    }

    public void setBlockBoundsForItemRender(World world, int x, int y, int z)
    {
    	float var1 = 0.5F;
        float var2 = 0.125F;
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
    }

    public int getMobilityFlag()
    {
        return 1;
    }
}
