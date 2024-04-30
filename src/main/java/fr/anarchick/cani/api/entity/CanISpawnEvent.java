package fr.anarchick.cani.api.entity;

import fr.anarchick.cani.internal.CanIEvent;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

@Getter
public class CanISpawnEvent extends CanIEvent {

    private final @NotNull Location location;
    private final @NotNull Class<? extends Entity> entityClass;
    private final @NotNull EntityType entityType;
    private final @NotNull CreatureSpawnEvent.SpawnReason reason;

    CanISpawnEvent(final @NotNull Location location, final @NotNull Class<? extends Entity> clazz, final @NotNull CreatureSpawnEvent.SpawnReason reason) {
        this.location = location;
        this.entityClass = clazz;
        this.entityType = getEntityType(clazz);
        this.reason = reason;
    }

    CanISpawnEvent(final @NotNull Location location, final @NotNull EntityType type, final @NotNull CreatureSpawnEvent.SpawnReason reason) {
        this.location = location;
        this.entityClass = type.getEntityClass();
        this.entityType = type;
        this.reason = reason;
    }

    private EntityType getEntityType(final @NotNull Class<? extends Entity> clazz) {
        for (EntityType type : EntityType.values()) {
            if (type.getEntityClass().equals(clazz)) {
                return type;
            }
        }
        return EntityType.UNKNOWN;
    }

}
