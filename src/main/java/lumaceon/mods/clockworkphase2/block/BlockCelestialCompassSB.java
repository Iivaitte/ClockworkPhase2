package lumaceon.mods.clockworkphase2.block;

import lumaceon.mods.clockworkphase2.init.ModBlocks;
import lumaceon.mods.clockworkphase2.tile.TileCelestialCompass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCelestialCompassSB extends BlockClockworkPhase
{
    public BlockCelestialCompassSB(Material blockMaterial, String unlocalizedName)
    {
        super(blockMaterial, unlocalizedName);
        this.setCreativeTab(null);
        this.setBlockUnbreakable();
        this.setResistance(1000000F);
        this.setLightLevel(1.0F);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        /*if(localY != 1.0F)
        {
            return false;
        }

        //Coordinates to be passed into the TextureHelper.
        int xOffset = 0;
        int zOffset = 0;

        meta = world.getBlockMetadata(x, y, z);
        ForgeDirection direction = ForgeDirection.getOrientation(meta);

        x += direction.offsetX;
        z += direction.offsetZ;

        xOffset += -direction.offsetX;
        zOffset += -direction.offsetZ;

        for(int n = 0; n < 10; n++)
        {
            if(world.getBlock(x, y, z) == null)
            {
                return false;
            }
            else if(world.getBlock(x, y, z).equals(ModBlocks.celestialCompass))
            {
                TileEntity te = world.getTileEntity(x, y, z);
                if(te != null && te instanceof TileCelestialCompass)
                {
                    return handleBlockClick(player, (TileCelestialCompass) te, xOffset + localX, zOffset + localZ);
                }
            }
            else
            {
                meta = world.getBlockMetadata(x, y, z);
                direction = ForgeDirection.getOrientation(meta);

                x += direction.offsetX;
                z += direction.offsetZ;

                xOffset += -direction.offsetX;
                zOffset += -direction.offsetZ;
            }
        }*/
        return false;
    }

    private boolean handleBlockClick(EntityPlayer player, TileCelestialCompass te, double xOffset, double zOffset)
    {
        if(!te.isAvailable() && !te.getWorld().isRemote)
            return false;
        if(Math.sqrt(Math.pow(xOffset - Ranges.CENTER_X, 2) + Math.pow(zOffset - Ranges.CENTER_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 8);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.TOP_X, 2) + Math.pow(zOffset - Ranges.TOP_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 0);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.TOP_RIGHT_X, 2) + Math.pow(zOffset - Ranges.TOP_RIGHT_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 1);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.RIGHT_X, 2) + Math.pow(zOffset - Ranges.RIGHT_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 2);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.BOTTOM_RIGHT_X, 2) + Math.pow(zOffset - Ranges.BOTTOM_RIGHT_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 3);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.BOTTOM_X, 2) + Math.pow(zOffset - Ranges.BOTTOM_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 4);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.BOTTOM_LEFT_X, 2) + Math.pow(zOffset - Ranges.BOTTOM_LEFT_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 5);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.LEFT_X, 2) + Math.pow(zOffset - Ranges.LEFT_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 6);
        }
        else if(Math.sqrt(Math.pow(xOffset - Ranges.TOP_LEFT_X, 2) + Math.pow(zOffset - Ranges.TOP_LEFT_Z, 2)) < 0.75F)
        {
            return te.onSubBlockClicked(player, 7);
        }
        else
        {
            return te.onSubBlockClicked(player, -1);
        }
    }

    private static int getTextureIndexFromCoordinates(int x, int z)
    {
        int index;

        //[0-4]
        if(x == -5)
        {
            z += 2;
            index = z;
        }
        //[5-11]
        else if(x == -4)
        {
            z += 3;
            index = z + 5;
        }
        //[12-20]
        else if(x == -3)
        {
            z += 4;
            index = z + 12;
        }
        //[21-75]
        else if(x >= -2 && x <= 2)
        {
            int indexOffset = x + 2;

            z += 5;
            index = z + 21 + (indexOffset * 11);
        }
        //[76-84]
        else if(x == 3)
        {
            z += 4;
            index = z + 76;
        }
        //[85-91]
        else if(x == 4)
        {
            z += 3;
            index = z + 85;
        }
        //[92-96]
        else if(x == 5)
        {
            z += 2;
            index = z + 92;
        }
        else
        {
            return 0;
        }

        if(index >= 48) { index--; }
        return index;
    }

    public static class Ranges
    {
        public static float CENTER_X = 0.50F;
        public static float CENTER_Z = 0.50F;

        public static float TOP_X = 0.50F;
        public static float TOP_Z = -3.45F;

        public static float TOP_RIGHT_X = 3.25F;
        public static float TOP_RIGHT_Z = -2.30F;

        public static float RIGHT_X = 4.40F;
        public static float RIGHT_Z = 0.50F;

        public static float BOTTOM_RIGHT_X = 3.25F;
        public static float BOTTOM_RIGHT_Z = 3.30F;

        public static float BOTTOM_X = 0.50F;
        public static float BOTTOM_Z = 4.35F;

        public static float BOTTOM_LEFT_X = -2.25F;
        public static float BOTTOM_LEFT_Z = 3.30F;

        public static float LEFT_X = -3.40F;
        public static float LEFT_Z = 0.50F;

        public static float TOP_LEFT_X = -2.25F;
        public static float TOP_LEFT_Z = -2.30F;
    }
}