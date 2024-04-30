package fr.anarchick.cani.internal;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public record DeclineInfo(JavaPlugin plugin, String message, Map<String, Object> data) {

    private static final String EMPTY = "";

    public DeclineInfo(@NotNull JavaPlugin plugin, @Nullable String message, @Nullable Map<String, Object> data) {
        this.plugin = plugin;
        this.message = (message != null) ? message : EMPTY;
        this.data = data;
    }

    @Override
    @NotNull
    public JavaPlugin plugin() {
        return plugin;
    }

    @Override
    @NotNull
    public String message() {
        return message;
    }

    @Override
    @NotNull
    public Map<String, Object> data() {
        return (data == null) ? new HashMap<>() : data;
    }

}
