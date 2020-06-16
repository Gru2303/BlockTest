package me.Gru2303.BlockTest;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new listener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }
}
