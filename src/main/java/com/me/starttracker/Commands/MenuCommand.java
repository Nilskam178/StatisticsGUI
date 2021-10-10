package com.me.starttracker.Commands;

import com.me.starttracker.Menu.CreateMenu;
import com.me.starttracker.Stats.AddStat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        CreateMenu createMenu = new CreateMenu();
        AddStat addStat = new AddStat(player);

        if(args != null) {
            if(args[0].equals("open")) {
                player.openInventory(CreateMenu.getInventory());
            }
        }
        else {
            sender.sendMessage("/stat open");
        }

        return true;
    }
}
