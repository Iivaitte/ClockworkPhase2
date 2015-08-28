package lumaceon.mods.clockworkphase2.api.time;

import net.minecraft.item.ItemStack;

/**
 * Implement this on items which hold time. Most items that use time should just use the method in the TimeHelper class
 * instead of implementing this.
 *
 * (Based off of the RF API - Credits to King Lemming)
 */
public interface ITimeContainer
{
    /**
     * Receives time into the timeItem passed in.
     * @param timeItem The ItemStack to receive time.
     * @param maxReceive The amount of time trying to be added.
     * @param simulate If true, a simulation will occur, but no time will actually be added.
     * @return The amount of time that was added successfully (or would have been added if simulated).
     */
    public long receiveTime(ItemStack timeItem, long maxReceive, boolean simulate);

    /**
     * Extracts time from the timeItem passed in.
     * @param timeItem The ItemStack to extract time from.
     * @param maxExtract The amount of time trying to be removed.
     * @param simulate If true, a simulation will occur, but no time will actually be removed.
     * @return The amount of time that was removed successfully (or would have been removed if simulated).
     */
    public long extractTime(ItemStack timeItem, long maxExtract, boolean simulate);

    /**
     * Returns the maximum amount of time that can be stored in this ItemStack.
     */
    public long getMaxCapacity(ItemStack timeItem);

    /**
     * Returns the amount of time that's stored in this ItemStack.
     */
    public long getTimeStored(ItemStack timeItem);
}
