package me.alchemy.repair;

import me.alchemy.repair.file.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class Repair extends JavaPlugin {

    private static Repair instance;

    @Override
    public void onEnable() {
        instance = this;
        Config.reload();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Repair getInstance() { return instance; }
}
