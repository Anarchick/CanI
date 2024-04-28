package fr.anarchick.cani.api.inventory.slot;

import lombok.Getter;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

@Getter
@SuppressWarnings("unused")
public class InventorySlot extends Slot {

    private final int slot;

    public InventorySlot(Inventory inv, int slot) {
        super(inv, InventoryType.SlotType.CONTAINER);
        this.slot = slot;
    }

    @Nullable
    @Override
    public ItemStack getItem() {
        return getInventory().getItem(slot);
    }

    @Override
    public void setItem(@Nullable ItemStack item) {
        getInventory().setItem(slot, item);
    }

}
