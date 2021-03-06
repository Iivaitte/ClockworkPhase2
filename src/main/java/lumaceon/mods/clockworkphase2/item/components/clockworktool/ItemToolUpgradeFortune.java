package lumaceon.mods.clockworkphase2.item.components.clockworktool;

import lumaceon.mods.clockworkphase2.api.item.IToolUpgrade;
import lumaceon.mods.clockworkphase2.api.util.internal.NBTHelper;
import lumaceon.mods.clockworkphase2.api.util.internal.NBTTags;
import lumaceon.mods.clockworkphase2.item.ItemClockworkPhase;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class ItemToolUpgradeFortune extends ItemClockworkPhase implements IToolUpgrade
{
    public ItemToolUpgradeFortune(int maxStack, int maxDamage, String unlocalizedName) {
        super(maxStack, maxDamage, unlocalizedName);
    }

    @Override
    public void setActive(ItemStack upgradeStack, ItemStack toolStack, boolean active) {
        NBTHelper.BOOLEAN.set(upgradeStack, NBTTags.ACTIVE, active);
        if(active)
            toolStack.addEnchantment(Enchantment.fortune, 3);
        else if(toolStack.isItemEnchanted())
        {
            Map enchantmentMap = EnchantmentHelper.getEnchantments(toolStack);
            enchantmentMap.remove(Enchantment.fortune.effectId);
            EnchantmentHelper.setEnchantments(enchantmentMap, toolStack);
        }
    }

    @Override
    public boolean getActive(ItemStack upgradeStack, ItemStack toolStack) {
        return NBTHelper.BOOLEAN.get(upgradeStack, NBTTags.ACTIVE);
    }
}
