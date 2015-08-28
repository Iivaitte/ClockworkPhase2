package lumaceon.mods.clockworkphase2.world.provider;

import lumaceon.mods.clockworkphase2.lib.Defaults;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderFirstAge extends WorldProviderSurface
{
    @Override
    public void registerWorldChunkManager()
    {
        this.dimensionId = Defaults.DIM_ID.FIRST_AGE;
        this.worldChunkMgr = new WorldChunkManager(getSeed(), WorldType.DEFAULT);
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderFirstAge(this.worldObj, getSeed(), false);
    }

    @Override
    public String getDimensionName() {
        return "The First Age";
    }
}
