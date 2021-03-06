package lumaceon.mods.clockworkphase2.item.construct.tool;

import com.google.common.collect.Sets;
import lumaceon.mods.clockworkphase2.api.util.internal.NBTHelper;
import lumaceon.mods.clockworkphase2.api.util.internal.NBTTags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class ItemClockworkShovel extends ItemClockworkTool
{
    private static final Set field_150916_c = Sets.newHashSet(new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public ItemClockworkShovel(ToolMaterial material, String unlocalizedName) {
        super(1.0F, material, field_150916_c, unlocalizedName);
    }

    @Override
    public boolean canHarvestBlock(Block p_150897_1_) {
        return p_150897_1_ == Blocks.snow_layer || p_150897_1_ == Blocks.snow;
    }

    @Override
    public String getHarvestType() {
        return "shovel";
    }

    @Override
    public Material[] getEffectiveMaterials() {
        return new Material[] { Material.ground, Material.grass, Material.sand, Material.snow };
    }

    @Override
    public void setTier(ItemStack item, int tier) {
        super.setTier(item, tier);
        NBTHelper.INT.set(item, NBTTags.HARVEST_LEVEL_SHOVEL, tier);
    }
}
