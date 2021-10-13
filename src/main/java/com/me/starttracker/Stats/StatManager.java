package com.me.starttracker.Stats;

import com.me.starttracker.Main;
import com.me.starttracker.Menu.CreateMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatManager {

    private Main main = Main.getInstance();


    public StatManager(Player player) {

        Inventory gui = CreateMenu.getInventory();

        //Death Stats
        ItemStack deathItem = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta deathMeta = deathItem.getItemMeta();

        deathMeta.setDisplayName(color("&eDEATHS: " + player.getStatistic(Statistic.DEATHS)));
        deathItem.setItemMeta(deathMeta);

        //Playtime stats
        ItemStack playtimeItem = new ItemStack(Material.CLOCK);
        ItemMeta playtimeMeta = playtimeItem.getItemMeta();

        playtimeMeta.setDisplayName(color("&ePLAYTIME IN MINUTES: " + (player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 1200)));
        playtimeItem.setItemMeta(playtimeMeta);

        //Assign items to inventory
        gui.setItem(0, deathItem);
        gui.setItem(1, playtimeItem);
    }

    private String color(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }

    public void addNewItems(Inventory gui, Player player) {

        if(!getAllTrackers().isEmpty()) {
            String[] materials = new String[getAllTrackers().size()];

            for (int i = 0; i < getAllTrackers().size(); i++) {
                materials[i] = getAllTrackers().get(i);

                if(!Objects.equals(materials[i], null)) {
                    ItemStack stat = new ItemStack(Material.valueOf(getCustomTracker(materials[i])[2]));
                    ItemMeta statMeta = stat.getItemMeta();

                    statMeta.setDisplayName(String.format(color("&e%s %s: %s"), getCustomTracker(materials[i])[0], getCustomTracker(materials[i])[1], getStat(player, getCustomTracker(materials[i])[0].toUpperCase())));
                    stat.setItemMeta(statMeta);

                    gui.setItem(Integer.parseInt(getCustomTracker(materials[i])[3]) - 1, stat);
                }
            }
        }
    }

    public void addCustomTracker(String statName, StatType statType, String type, String icon, String slotNumber) {
        String path = "Trackers." + statName;

        main.getTrackerModFile().set(path, String.format("%s@%s@%s@%s", type.toUpperCase(), statType.statString.toUpperCase(), icon.toUpperCase(), slotNumber));

        try {
            main.getTrackerModFile().save(main.getTrackerFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getCustomTracker(String statName) {
        String path = "Trackers." + statName;

        String value = main.getTrackerModFile().getString(path);

        return value.split("@");
    }

    public List<String> getAllTrackers() {
        List<String> list = new ArrayList<>();

        if(main.getTrackerModFile().getKeys(true).size() != 0) {
            list.addAll(main.getTrackerModFile().getConfigurationSection("Trackers").getKeys(false));
        }
        return list;
    }

    public void addStat(Player player, String stat) {
        String path = "Stat." + player.getUniqueId() + "." + stat;

        main.getStatModFile().set(path, main.getStatModFile().getInt(path) + 1);

        try {
            main.getStatModFile().save(main.getStatFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStat(Player player, String stat, int value) {
        String path = "Stat." + player.getUniqueId() + "." + stat;

        main.getStatModFile().set(path, value);
    }

    public String getStat(Player player, String stat) {
        String path = "Stat." + player.getUniqueId() + "." + stat;

        return main.getStatModFile().getString(path);
    }

    public void removeStat(String statName
    ) {
        Inventory gui = CreateMenu.getInventory();
        gui.setItem(Integer.parseInt(getCustomTracker(statName)[3]) - 1, new ItemStack(Material.AIR));

        main.getTrackerModFile().set("Trackers." + statName, null);

        try {
            main.getTrackerModFile().save(main.getTrackerFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
