package fr.anarchick.cani.internal;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

@SuppressWarnings("unused")
public class Response {

    private boolean can = true;
    private final HashSet<DeclineInfo> declineInfoSet = new HashSet<>();

    public boolean isAccepted() {
        return this.can;
    }

    public boolean isDeclined() {
        return !this.can;
    }

    public void decline(final @NotNull JavaPlugin plugin, final @Nullable String message, final @Nullable Map<String, Object> data) {
        this.can = false;
        this.declineInfoSet.add(new DeclineInfo(plugin, message, data));
    }

    @Unmodifiable
    @NotNull
    public Collection<DeclineInfo> getAllDeclineInfo() {
        return Collections.unmodifiableSet(this.declineInfoSet);
    }

    public boolean isAcceptedOrOnlyDeclineBy(final @NotNull String... plugins) {
        final PluginManager pluginManager =Bukkit.getPluginManager();
        final JavaPlugin[] javaPlugins = Arrays.stream(plugins)
                .map(pluginManager::getPlugin)
                .filter(Objects::nonNull)
                .toArray(JavaPlugin[]::new);
        return isAcceptedOrOnlyDeclineBy(javaPlugins);
    }

    public boolean isAcceptedOrOnlyDeclineBy(final @NotNull JavaPlugin... plugins) {
        if (isAccepted()) {
            return true;
        }

        return this.declineInfoSet.stream().allMatch(declineInfo ->
                Arrays.stream(plugins).anyMatch(plugin -> declineInfo.getPlugin().equals(plugin))
        );
    }

}
