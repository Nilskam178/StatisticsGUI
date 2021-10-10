package com.me.starttracker.Menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class CreateMenu {

    private static Inventory gui;

    private String color(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }

    public CreateMenu() {
        gui = Bukkit.createInventory(null, 18, color("&6Statistics menu"));
    }

    public static Inventory getInventory() { return gui; }
}
