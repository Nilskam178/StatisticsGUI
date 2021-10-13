package com.me.starttracker;

import com.me.starttracker.Commands.MenuCommand;
import com.me.starttracker.Menu.CreateMenu;
import com.me.starttracker.Menu.MenuInteraction;
import com.me.starttracker.Stats.StatListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class Main extends JavaPlugin {

    private static Main instance;

    private File statFile;
    private YamlConfiguration modifyStatFile;

    private File trackerFile;
    private YamlConfiguration modifyTrackerFile;

    @Override
    public void onEnable() {

        instance = this;

        this.getCommand("stat").setExecutor(new MenuCommand());
        getServer().getPluginManager().registerEvents(new MenuInteraction(), this);
        getServer().getPluginManager().registerEvents(new StatListener(), this);

        CreateMenu createMenu = new CreateMenu();

        try {
            initiateFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() { return instance; }

    public YamlConfiguration getStatModFile() { return modifyStatFile; }
    public File getStatFile() { return statFile; }

    public YamlConfiguration getTrackerModFile() { return modifyTrackerFile; }
    public File getTrackerFile() { return trackerFile; }

    private void initiateFiles() throws IOException {

        statFile = new File(Bukkit.getServer().getPluginManager().getPlugin(getDescription().getName()).getDataFolder(), "Custom_Stats.yml");
        trackerFile = new File(Bukkit.getServer().getPluginManager().getPlugin(getDescription().getName()).getDataFolder(), "Custom_Tracker.yml");

        File dir = statFile.getParentFile();
        dir.mkdirs();

        if(!statFile.exists()) {
            statFile.createNewFile();
        }

        if(!trackerFile.exists()) {
            trackerFile.createNewFile();
        }

        modifyStatFile = YamlConfiguration.loadConfiguration(statFile);
        modifyTrackerFile = YamlConfiguration.loadConfiguration(trackerFile);
    }
}
