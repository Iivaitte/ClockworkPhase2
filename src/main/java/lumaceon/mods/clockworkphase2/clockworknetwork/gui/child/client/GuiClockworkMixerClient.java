package lumaceon.mods.clockworkphase2.clockworknetwork.gui.child.client;

import lumaceon.mods.clockworkphase2.lib.Textures;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class GuiClockworkMixerClient extends GuiCN
{
    public GuiClockworkMixerClient(TileEntity te, int xSize, int ySize) {
        super(te, xSize, ySize);
    }

    @Override
    public void drawBackground(int left, int top, float zLevel) {
        Minecraft.getMinecraft().renderEngine.bindTexture(Textures.GUI.MIXER);
        this.drawTexturedModalRect(left, top, xSize, ySize, zLevel);
    }

    @Override
    public void drawForeground(int left, int top, float zLevel) {}
}
