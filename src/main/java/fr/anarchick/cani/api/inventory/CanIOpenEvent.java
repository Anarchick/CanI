package fr.anarchick.cani.api.inventory;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class CanIOpenEvent extends CanIEvent {

    /**
     * The entity that is trying to open the inventory
     * Maybe a custom Entity and not a Player ?
     */
    private final @NotNull Entity entity;
    private final @NotNull Inventory inventory;
    private final boolean ignoreDistance;

}
