package com.me.starttracker.Commands;

import com.me.starttracker.Menu.CreateMenu;
import com.me.starttracker.Stats.StatManager;
import com.me.starttracker.Stats.StatType;
import com.me.starttracker.Utils.EntityUtil;
import com.me.starttracker.Utils.EnumUtil;
import org.apache.commons.lang.enums.EnumUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Objects;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        StatManager statManager = new StatManager(player);

        if(args.length != 0) {
            if(args[0].equalsIgnoreCase("open")){

                statManager.addNewItems(CreateMenu.getInventory(), player);
                player.openInventory(CreateMenu.getInventory());
            }
            else if(args[0].equalsIgnoreCase("add") && sender.hasPermission("stat.admin")) {
                if(args.length > 1) {
                    if(args.length > 2 && EnumUtil.validEnum(args[2].toUpperCase())) {
                        if(args.length > 3) {
                            if(Material.matchMaterial(args[3].toUpperCase()) != null || EntityUtil.ValidEntity(args[3].toUpperCase())) {
                                if(args.length > 4 && Material.matchMaterial(args[4].toUpperCase()) != null) {
                                    if(args.length > 5 && CreateMenu.getInventory().getItem(Integer.parseInt(args[5]) - 1) == null) {

                                        statManager.addCustomTracker(args[1], StatType.valueOf(args[2].toUpperCase()), args[3], args[4], args[5]);
                                        statManager.setStat(player, args[3].toUpperCase(), 0);
                                        statManager.addNewItems(CreateMenu.getInventory(), player);
                                        player.openInventory(CreateMenu.getInventory());
                                    }
                                    else {
                                        sender.sendMessage("Slot is not empty/Need to specify slot number");
                                    }
                                }
                                else {
                                    sender.sendMessage("Not a valid icon material/Need to specify icon material");
                                }
                            }
                            else {
                                sender.sendMessage("Not a valid target");
                            }
                        }
                        else {
                            sender.sendMessage("Need to specify target");
                        }
                    }
                    else {
                        sender.sendMessage("Not a valid stat type/Need to specify a stat type");
                    }
                }
                else {
                    sender.sendMessage("You need to specify a name for your tracker");
                }
            }
            else if(args[0].equalsIgnoreCase("remove") && sender.hasPermission("stat.admin")){
                if(args.length > 1) {

                    for (int i = 0; i < statManager.getAllTrackers().size(); i++) {
                        if(Objects.equals(statManager.getAllTrackers().get(i), args[1])) {
                            statManager.removeStat(args[1]);
                        }
                    }
                }
                else {
                    sender.sendMessage("Provide a tracker name");
                }
            }
            else if(args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("/stat add <tracker name> <kill/mine> <entityID> <materialID> <slot number/27 slots>\n /stat remove <tracker name>");
            }
            else{
                sender.sendMessage("Use /stat open/add/remove");
            }
        }
        else{
            sender.sendMessage("Use /stat open/add/remove");
        }

        return false;
    }
}
