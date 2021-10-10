package com.me.starttracker.Stats;

import com.me.starttracker.Menu.CreateMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddStat {

    private String color(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }

    public AddStat(Player player) {

        Inventory gui = CreateMenu.getInventory();

        //Death Stats
        ItemStack deathItem = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta deathMeta = deathItem.getItemMeta();

        deathMeta.setDisplayName(color("&eDeaths: " + player.getStatistic(Statistic.DEATHS)));
        deathItem.setItemMeta(deathMeta);

        //Player kill stats
        ItemStack playerKillItem = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta playerKillMeta = playerKillItem.getItemMeta();

        playerKillMeta.setDisplayName(color("&eKills: " + player.getStatistic(Statistic.PLAYER_KILLS)));
        playerKillItem.setItemMeta(playerKillMeta);

        //Playtime stats
        ItemStack playtimeItem = new ItemStack(Material.CLOCK);
        ItemMeta playtimeMeta = playtimeItem.getItemMeta();

        playtimeMeta.setDisplayName(color("&ePlaytime in minutes: " + (player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 1200)));
        playtimeItem.setItemMeta(playtimeMeta);

        //Mobkills
        ItemStack mobkillsItem = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta mobkillsMeta = mobkillsItem.getItemMeta();

        mobkillsMeta.setDisplayName(color("&eMobkills: " + player.getStatistic(Statistic.MOB_KILLS)));
        mobkillsItem.setItemMeta(mobkillsMeta);

        //Emerald mined
        ItemStack emeraldMinedItem = new ItemStack(Material.EMERALD_ORE);
        ItemMeta emeraldMinedMeta = emeraldMinedItem.getItemMeta();

        emeraldMinedMeta.setDisplayName(color("&eEmeralds mined: " + (player.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE)
                + player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_EMERALD_ORE))));
        emeraldMinedItem.setItemMeta(emeraldMinedMeta);

        //Diamond mined
        ItemStack diamondMinedItem = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta diamondMinedMeta = diamondMinedItem.getItemMeta();

        diamondMinedMeta.setDisplayName(color("&eDiamonds mined: " + (player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE)
                + player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE))));
        diamondMinedItem.setItemMeta(diamondMinedMeta);

        //Gold mined
        ItemStack goldMinedItem = new ItemStack(Material.GOLD_ORE);
        ItemMeta goldMinedMeta = goldMinedItem.getItemMeta();

        goldMinedMeta.setDisplayName(color("&eGold mined: " + (player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE)
                + player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE))));
        goldMinedItem.setItemMeta(goldMinedMeta);

        //Iron mined
        ItemStack ironMinedItem = new ItemStack(Material.IRON_ORE);
        ItemMeta ironMinedMeta = ironMinedItem.getItemMeta();

        ironMinedMeta.setDisplayName(color("&eIron mined: " + (player.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE)
                + player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_IRON_ORE))));
        ironMinedItem.setItemMeta(ironMinedMeta);

        //Coal mined
        ItemStack coalMinedItem = new ItemStack(Material.COAL_ORE);
        ItemMeta coalMinedMeta = coalMinedItem.getItemMeta();

        coalMinedMeta.setDisplayName(color("&eCoal mined: " + (player.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE)
                + player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_COAL_ORE))));
        coalMinedItem.setItemMeta(coalMinedMeta);

        //Netherite mined
        ItemStack netheriteMinedItem = new ItemStack(Material.ANCIENT_DEBRIS);
        ItemMeta netheriteMinedMeta = netheriteMinedItem.getItemMeta();

        netheriteMinedMeta.setDisplayName(color("&eNetherite mined: " + player.getStatistic(Statistic.MINE_BLOCK, Material.ANCIENT_DEBRIS)));
        netheriteMinedItem.setItemMeta(netheriteMinedMeta);

        //Quartz mined
        ItemStack quartzMinedItem = new ItemStack(Material.NETHER_QUARTZ_ORE);
        ItemMeta quartzMinedMeta = quartzMinedItem.getItemMeta();

        quartzMinedMeta.setDisplayName(color("&eQuartz mined: " + player.getStatistic(Statistic.MINE_BLOCK, Material.NETHER_QUARTZ_ORE)));
        quartzMinedItem.setItemMeta(quartzMinedMeta);

        //Raid wins
        ItemStack raidWinsItem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta raidWinsMeta = raidWinsItem.getItemMeta();

        raidWinsMeta.setDisplayName(color("&eRaid wins: " + player.getStatistic(Statistic.RAID_WIN)));
        raidWinsItem.setItemMeta(raidWinsMeta);

        //Damage done
        ItemStack damageDoneItem = new ItemStack(Material.IRON_SWORD);
        ItemMeta damageDoneMeta = damageDoneItem.getItemMeta();
        damageDoneMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        damageDoneMeta.setDisplayName(color("&eDamage done: " + player.getStatistic(Statistic.DAMAGE_DEALT)));
        damageDoneItem.setItemMeta(damageDoneMeta);

        //Damage taken
        ItemStack damageTakenItem = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta damageTakenMeta = damageTakenItem.getItemMeta();
        damageTakenMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        damageTakenMeta.setDisplayName(color("&eDamage taken: " + player.getStatistic(Statistic.DAMAGE_TAKEN)));
        damageTakenItem.setItemMeta(damageTakenMeta);

        //Assign items to inventory
        gui.setItem(1, deathItem);
        gui.setItem(2, playerKillItem);
        gui.setItem(3, playtimeItem);
        gui.setItem(4, mobkillsItem);
        gui.setItem(5, raidWinsItem);
        gui.setItem(6, damageDoneItem);
        gui.setItem(7, damageTakenItem);

        //Mined blocks
        gui.setItem(10, emeraldMinedItem);
        gui.setItem(11, diamondMinedItem);
        gui.setItem(12, goldMinedItem);
        gui.setItem(13, ironMinedItem);
        gui.setItem(14, coalMinedItem);
        gui.setItem(15, netheriteMinedItem);
        gui.setItem(16, quartzMinedItem);
    }
}

