package fr.anarchick.cani.internal;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class DeclineInfo {

    private static final String EMPTY = "";

    private final JavaPlugin plugin;
    private final String message;
    private final Map<String, Object> data;

    public DeclineInfo(@NotNull JavaPlugin plugin, @Nullable String message, @Nullable Map<String, Object> data) {
        this.plugin = plugin;
        this.message = (message != null) ? message : EMPTY;
        this.data = data;
    }

    @NotNull
    public JavaPlugin getPlugin() {
        return plugin;
    }

    @NotNull
    public String getMessage() {
        return message;
    }

    @NotNull
    public Map<String, Object> getData() {
        return (data == null) ? new HashMap<>() : data;
    }

}
