package de.skycentral.sb.schematic;

import de.skycentral.sb.utils.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_schematic implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player)sender;
        if(p.hasPermission("schematic.command.use")) {

            if(args.length == 3) {

                if(args[0].equalsIgnoreCase("create")) {

                    int radius = 0;
                    String name = args[1];

                    try {
                        radius = Integer.parseInt(args[2]);
                    } catch (Exception ex) {
                        p.sendMessage(Data.prefix + "Das §b3. Argument §7muss eine Zahl sein!");
                    }

                    Schematic schematic = new Schematic(name);
                    schematic.setLocation(p.getLocation());
                    schematic.setRadius(radius);
                    schematic.save();
                    p.sendMessage(Data.prefix + "Du hast eine §bneue Schematic §7gesichert!");

                }

            }else if(args.length == 2) {

                if(args[0].equalsIgnoreCase("load")) {

                    String name = args[1];
                    Schematic schematic = new Schematic(name);
                    schematic.load();
                    p.sendMessage(Data.prefix + "Du hast die Schematic §b" + name + " §7geladen!");

                }

            }else {

            }

        }


        return false;
    }
}
