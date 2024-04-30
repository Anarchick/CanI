package fr.anarchick.cani;

import com.jeff_media.updatechecker.UpdateCheckSource;
import com.jeff_media.updatechecker.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class CanI extends JavaPlugin {

    @Override
    public void onEnable() {
        checkUpdate();
    }

    @Override
    public void onDisable() {}

    private void checkUpdate() {
        new UpdateChecker(this, UpdateCheckSource.GITHUB_RELEASE_TAG, "Anarchick/CanI")
                .setDownloadLink("https://github.com/Anarchick/CanI/releases")
                .checkNow();
    }

}
