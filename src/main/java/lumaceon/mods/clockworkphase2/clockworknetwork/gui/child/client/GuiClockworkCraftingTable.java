package lumaceon.mods.clockworkphase2.clockworknetwork.gui.child.client;

import lumaceon.mods.clockworkphase2.api.clockworknetwork.ClockworkNetworkGuiClient;
import lumaceon.mods.clockworkphase2.inventory.slot.SlotNever;
import lumaceon.mods.clockworkphase2.lib.Textures;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiClockworkCraftingTable extends ClockworkNetworkGuiClient
{
    private static Minecraft mc;
    protected Slot[] slots;

    public GuiClockworkCraftingTable(TileEntity te, int xSize, int ySize) {
        super(te, xSize, ySize);
        mc = Minecraft.getMinecraft();
        slots = new Slot[10];
        if(te != null && te instanceof IInventory)
        {
            IInventory inventory = (IInventory) te;

            //From the ContainerWorkbench class.
            int l;
            int i1;
            for (l = 0; l < 3; ++l)
                for (i1 = 0; i1 < 3; ++i1)
                    slots[i1 + l * 3] = new Slot(inventory, i1 + l * 3, 1 + i1 * 18, 1 + l * 18);

            slots[9] = new SlotNever(inventory, 9, 81, 19);
        }
    }

    @Override
    public void drawBackground(int left, int top, float zLevel) {
        mc.getTextureManager().bindTexture(Textures.GUI.CRAFTING_TABLE);
        this.drawTexturedModalRect(left, top, xSize, ySize, zLevel);
    }

    @Override
    public void drawForeground(int left, int top, float zLevel) {}

    @Override
    public Slot[] getSlots() {
        return slots;
    }
}
