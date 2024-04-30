package fr.anarchick.cani.api.inventory.slot;

import lombok.Getter;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class PlayerEquipmentSlot extends Slot {

    @Getter
    private final EquipmentSlot slot;
    private final PlayerInventory playerInv;

    public PlayerEquipmentSlot(PlayerInventory inv, EquipmentSlot slot) {
        super(inv, InventoryType.SlotType.ARMOR);
        this.slot = slot;
        this.playerInv = inv;
    }

    @Nullable
    @Override
    public ItemStack getItem() {
        return switch (slot) {
            case HEAD -> playerInv.getHelmet();
            case CHEST -> playerInv.getChestplate();
            case LEGS -> playerInv.getLeggings();
            case FEET -> playerInv.getBoots();
            case HAND -> playerInv.getItemInMainHand();
            case OFF_HAND -> playerInv.getItemInOffHand();
        };
    }

    @Override
    public void setItem(@Nullable ItemStack item) {
        switch (slot) {
            case HEAD -> playerInv.setHelmet(item);
            case CHEST -> playerInv.setChestplate(item);
            case LEGS -> playerInv.setLeggings(item);
            case FEET -> playerInv.setBoots(item);
            case HAND -> playerInv.setItemInMainHand(item);
            case OFF_HAND -> playerInv.setItemInOffHand(item);
        }
    }

}
