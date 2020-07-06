package de.skycentral.sb.commands;

import de.skycentral.sb.gui.IslandGUI;
import de.skycentral.sb.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Island implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        IslandGUI islandGUI = new IslandGUI();
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("island")) {
            if(args.length == 0) {
                islandGUI.openIslandGUI(p);
                Bukkit.broadcastMessage("DEBUG");
            } else {
                p.sendMessage(Data.use + "island help");
            }
        }
        return false;
    }
}
