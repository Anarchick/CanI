package fr.anarchick.cani.api.entity;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class CanIAddPassengerEvent extends CanIEvent {

    private final @NotNull Entity vehicle;
    private final @NotNull Entity passenger;
    private final boolean ignoreDistance;

}
