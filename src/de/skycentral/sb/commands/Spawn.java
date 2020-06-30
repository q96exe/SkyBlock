package de.skycentral.sb.commands;

import de.skycentral.sb.main.Main;
import de.skycentral.sb.utils.Data;
import de.skycentral.sb.utils.LocationManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        LocationManager locationManager = Main.getInstance().getLocationManager();
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("spawn")) {
            if(args.length == 0) {
                p.teleport(locationManager.getSpawn());
                p.sendMessage(Data.prefix + "Du wurdest zum §aSpawn §7teleportiert");
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 3, 3);
            } else {
                p.sendMessage(Data.use + "spawn");
            }
        }

        return false;
    }
}
