package fr.anarchick.cani.api.inventory;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor
public class CanIAddItemEvent extends CanIEvent {

    /**
     * The entity that is trying to modify the inventory
     * Maybe a custom Entity and not a Player ?
     */
    private final @Nullable Entity entity;
    private final @NotNull Inventory inventory;
    private final @NotNull ItemStack item;
    private final boolean ignoreDistance;

}
