package huntingTraps.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class FakeGrass extends Block
{
	int b = 1;
	
	public FakeGrass(int i, int j)
	{
		super(i, j, Material.ground);
        this.blockIndexInTexture = 0;
        this.setBlockBounds(0.0F, 0.99F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double var1 = 0.5D;
        double var3 = 1.0D;
        return ColorizerGrass.getGrassColor(var1, var3);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1)
    {
        return this.getBlockColor();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;

        for (int var8 = -1; var8 <= 1; ++var8)
        {
            for (int var9 = -1; var9 <= 1; ++var9)
            {
                int var10 = par1IBlockAccess.getBiomeGenForCoords(par2 + var9, par4 + var8).getBiomeGrassColor();
                var5 += (var10 & 16711680) >> 16;
                var6 += (var10 & 65280) >> 8;
                var7 += var10 & 255;
            }
        }

        return (var5 / 9 & 255) << 16 | (var6 / 9 & 255) << 8 | var7 / 9 & 255;
    }
    
	public void setBlockBoundsForItemRender(World world, int x, int y, int z)
    {
		float f = 0.0625F;
        this.setBlockBounds(x + f, y + f, z + f, x + 1 - f, y + 1 - f, z + 1 - f);
    }
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	{
		return null;
	}
	
	public boolean blocksMovement()
    {
        return false;
    }
}