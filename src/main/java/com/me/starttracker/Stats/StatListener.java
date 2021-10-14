package com.me.starttracker.Stats;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Objects;

public class StatListener implements Listener {

    @EventHandler
    public void onKill(EntityDeathEvent event) {
        if(event.getEntity().getKiller() != null) {

            Player player = event.getEntity().getKiller();
            StatManager statManager = new StatManager(player);

            for (int i = 0; i < statManager.getAllTrackers().size(); i++) {

                String[] entity = new String[statManager.getAllTrackers().size()];
                entity[i] = statManager.getAllTrackers().get(i);

                if(Objects.equals(statManager.getCustomTracker(entity[i])[1].toLowerCase(), StatType.KILL.statString)) {
                    if(Objects.equals(statManager.getCustomTracker(entity[i])[0], event.getEntityType().name())) {
                        statManager.addStat(player, event.getEntityType().name());
                    }
                }
            }
        }
    }

    @EventHandler
    public void onMine(BlockBreakEvent event) {

        if(event.getPlayer() != null) {
            Player player = event.getPlayer();
            StatManager statManager = new StatManager(event.getPlayer());

            for (int i = 0; i < statManager.getAllTrackers().size(); i++) {

                String[] materials = new String[statManager.getAllTrackers().size()];
                materials[i] = statManager.getAllTrackers().get(i);

                if(Objects.equals(statManager.getCustomTracker(materials[i])[1].toLowerCase(), StatType.MINE.statString)) {
                    if(Objects.equals(statManager.getCustomTracker(materials[i])[0], event.getBlock().getType().name())) {
                        statManager.addStat(player, event.getBlock().getType().name());
                    }
                }
            }
        }
    }
}
