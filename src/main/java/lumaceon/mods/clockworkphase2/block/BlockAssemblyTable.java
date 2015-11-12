package lumaceon.mods.clockworkphase2.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lumaceon.mods.clockworkphase2.ClockworkPhase2;
import lumaceon.mods.clockworkphase2.init.ModBlocks;
import lumaceon.mods.clockworkphase2.lib.Textures;
import lumaceon.mods.clockworkphase2.tile.TileAssemblyTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockAssemblyTable extends BlockDirectional implements ITileEntityProvider
{
    public BlockAssemblyTable(Material blockMaterial, String unlocalizedName) {
        super(blockMaterial);
        this.setCreativeTab(ClockworkPhase2.instance.CREATIVE_TAB);
        this.setHardness(3.0F);
        this.setBlockName(unlocalizedName);
    }

    /*@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.getBlock(x, y, z).isReplaceable(world, x, y, z)
                && world.getBlock();
    }*/

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
    {
        super.onBlockPlacedBy(world, x, y, z, entity, item);
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if(direction == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, ForgeDirection.NORTH.ordinal(), 2);
            world.setBlock(x+1, y, z, ModBlocks.assemblyTableSB, ForgeDirection.WEST.ordinal(), 2);
        }
        else if(direction == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, ForgeDirection.EAST.ordinal(), 2);
            world.setBlock(x, y, z+1, ModBlocks.assemblyTableSB, ForgeDirection.NORTH.ordinal(), 2);
        }
        else if(direction == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, ForgeDirection.SOUTH.ordinal(), 2);
            world.setBlock(x-1, y, z, ModBlocks.assemblyTableSB, ForgeDirection.EAST.ordinal(), 2);
        }
        else if(direction == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, ForgeDirection.WEST.ordinal(), 2);
            world.setBlock(x, y, z-1, ModBlocks.assemblyTableSB, ForgeDirection.SOUTH.ordinal(), 2);
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        super.breakBlock(world, x, y, z, block, meta);
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
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileAssemblyTable();
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

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf('.') + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister registry) {
        this.blockIcon = registry.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
