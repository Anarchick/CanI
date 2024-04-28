package fr.anarchick.cani.api.block;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor
public class CanIBreakEvent extends CanIEvent {

    private final @NotNull Block block;
    private final @Nullable Player player;
    private final @Nullable ItemStack tool;
    private boolean ignoreDistance;

}
