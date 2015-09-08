package lumaceon.mods.clockworkphase2.proxy;

import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.IRenderHandler;

public interface IProxy
{
    public void registerTESR();
    public void registerModels();
    public void registerKeybindings();
    public void initSideHandlers();
    public void addWorldRenderer(World world, int x, int y, int z, int ID);
    public void clearWorldRenderers(World world, int x, int y, int z);
    public IRenderHandler getSkyRendererForWorld(WorldProvider worldProvider);
}
