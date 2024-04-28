package fr.anarchick.cani.api.entity;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class CanITeleportEvent extends CanIEvent {

    private final @NotNull Entity entity;
    private final @NotNull Location loc;
    private final @NotNull PlayerTeleportEvent.TeleportCause cause;
    private final boolean ignoreDistance;

}
