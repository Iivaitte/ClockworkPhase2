package lumaceon.mods.clockworkphase2.block.clockwork;

import lumaceon.mods.clockworkphase2.api.block.clockwork.IClockworkTile;
import lumaceon.mods.clockworkphase2.block.BlockClockworkPhase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCrank extends BlockClockworkPhase
{
    public BlockCrank(Material blockMaterial, String unlocalizedName) {
        super(blockMaterial, unlocalizedName);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float f0, float f1, float f2)
    {
        if(!player.isSneaking())
        {
            TileEntity te = world.getTileEntity(x + 1, y, z);
            if(te != null && te instanceof IClockworkTile)
            {
                ((IClockworkTile) te).wind(1000 * 10);
                return false;
            }
            te = world.getTileEntity(x - 1, y, z);
            if(te != null && te instanceof IClockworkTile)
            {
                ((IClockworkTile) te).wind(1000 * 10);
                return false;
            }
            te = world.getTileEntity(x, y + 1, z);
            if(te != null && te instanceof IClockworkTile)
            {
                ((IClockworkTile) te).wind(1000 * 10);
                return false;
            }
            te = world.getTileEntity(x, y - 1, z);
            if(te != null && te instanceof IClockworkTile)
            {
                ((IClockworkTile) te).wind(1000 * 10);
                return false;
            }
            te = world.getTileEntity(x, y, z + 1);
            if(te != null && te instanceof IClockworkTile)
            {
                ((IClockworkTile) te).wind(1000 * 10);
                return false;
            }
            te = world.getTileEntity(x, y, z - 1);
            if(te != null && te instanceof IClockworkTile)
            {
                ((IClockworkTile) te).wind(1000 * 10);
                return false;
            }
        }
        return false;
    }
}
