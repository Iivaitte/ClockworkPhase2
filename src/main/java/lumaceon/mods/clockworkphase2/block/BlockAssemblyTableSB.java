package lumaceon.mods.clockworkphase2.block;

import lumaceon.mods.clockworkphase2.ClockworkPhase2;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockAssemblyTableSB extends BlockClockworkPhase
{
    public BlockAssemblyTableSB(Material blockMaterial, String unlocalizedName) {
        super(blockMaterial, unlocalizedName);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float f0, float f1, float f2)
    {
        if(!player.isSneaking())
        {
            if(!world.isRemote)
                player.openGui(ClockworkPhase2.instance, 0, world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getMobilityFlag() {
        return 1;
    }
}
