package fr.anarchick.cani.internal;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
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
    @Nullable private Object from = null;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    /**
     * Ask without any context.
     * @return the response
     * */
    @NotNull
    public Response ask() {
        PLUGIN_MANAGER.callEvent(this);
        return this.response;
    }

    /**
     * Ask from a JavaPlugin.
     * @param plugin the JavaPlugin that asked the question
     * @return the response
     * */
    @NotNull
    public Response askFrom(JavaPlugin plugin) {
        this.from = plugin;
        return ask();
    }

    /**
     * Ask from a CommandSender.
     * @param sender the CommandSender that asked the question
     * @return the response
     * */
    @NotNull
    public Response askFrom(CommandSender sender) {
        this.from = sender;
        return ask();
    }

    /**
     * Get the object that asked the question.
     * Maybe a JavaPlugin or a CommandSender.
     * @return the object that asked or null
     * */
    @Nullable
    public Object from() {
        return from;
    }

    @NotNull
    public Response getResponse() {
        return response;
    }

    public void decline(@NotNull JavaPlugin plugin, @Nullable String message, @Nullable Map<String, Object> data) {
        response.decline(plugin, message, data);
    }

}
