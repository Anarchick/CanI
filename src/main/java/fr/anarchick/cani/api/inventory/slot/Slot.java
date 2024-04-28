package fr.anarchick.cani.api.inventory.slot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@Getter
@AllArgsConstructor
@SuppressWarnings("unused")
public abstract class Slot {

    private final Inventory inventory;
    private final InventoryType.SlotType type;

    abstract public ItemStack getItem();

    abstract public void setItem(ItemStack item);

}
