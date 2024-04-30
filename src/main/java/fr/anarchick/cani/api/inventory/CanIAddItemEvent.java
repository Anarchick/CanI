package fr.anarchick.cani.api.inventory;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class CanIAddItemEvent extends CanIEvent {

    private final @NotNull Inventory inventory;
    private final @NotNull ItemStack item;

}
