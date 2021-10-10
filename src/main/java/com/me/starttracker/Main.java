package com.me.starttracker;

import com.me.starttracker.Commands.MenuCommand;
import com.me.starttracker.Menu.MenuInteraction;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public final class Main extends JavaPlugin {

    private File statFile;
    private YamlConfiguration modifyStatFile;

    @Override
    public void onEnable() {

        this.getCommand("stat").setExecutor(new MenuCommand());
        getServer().getPluginManager().registerEvents(new MenuInteraction(), this);
    }

    @Override
    public void onDisable() {

    }
}
