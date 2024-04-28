package fr.anarchick.cani.internal;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public abstract class CanIEvent extends Event {

    private static final PluginManager PLUGIN_MANAGER = Bukkit.getPluginManager();

    private final HandlerList handlerList = new HandlerList();
    private final Response response = new Response();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public Response ask() {
        PLUGIN_MANAGER.callEvent(this);
        return this.response;
    }

    @NotNull
    public Response getResponse() {
        return response;
    }

    public void decline(@NotNull JavaPlugin plugin, @Nullable String message, @Nullable Map<String, Object> data) {
        response.decline(plugin, message, data);
    }

}
