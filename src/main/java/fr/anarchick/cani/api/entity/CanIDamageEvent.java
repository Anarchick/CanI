package fr.anarchick.cani.api.entity;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor
public class CanIDamageEvent extends CanIEvent {

    private final @NotNull Entity victim;
    private final @Nullable Entity attacker;
    private final @Nullable ItemStack tool;
    private final @NotNull EntityDamageEvent.DamageCause cause;
    private final double damage;
    private final boolean ignoreDistance;

}
