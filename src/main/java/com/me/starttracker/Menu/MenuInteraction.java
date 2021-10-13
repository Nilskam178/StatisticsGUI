package com.me.starttracker.Menu;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuInteraction implements Listener {

    private String color(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }

    @EventHandler
    public void interactMenu(InventoryClickEvent event) {

        if(event.getView().getTitle().equals(color("&6Statistics menu"))) {
            if(event.getCurrentItem() != null)
                event.setCancelled(true);
        }
    }
}
