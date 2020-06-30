package de.skycentral.sb.commands;

import de.skycentral.sb.main.Main;
import de.skycentral.sb.utils.Data;
import de.skycentral.sb.utils.LocationManager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        LocationManager locationManager = Main.getInstance().getLocationManager();
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("setspawn")) {
            if(p.hasPermission("sb.admin") || p.hasPermission("sb.*")) {
                if(args.length == 0) {
                    locationManager.setSpawn(p.getLocation());
                    p.sendMessage(Data.prefix + "Du hast den Spawn erfolgreich gesetzt");
                    p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 4, 4);
                } else {
                    p.sendMessage(Data.use + "setspawn");
                }
            } else {
                p.sendMessage(Data.noperms);
            }
        }
        return false;
    }
}
