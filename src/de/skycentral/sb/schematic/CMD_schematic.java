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

                }else {
                    p.sendMessage(Data.prefix + "Verwende: ");
                    p.sendMessage(Data.prefix + " §a/schematic list");
                    p.sendMessage(Data.prefix + " §a/schematic create <Name> <Radius>");
                    p.sendMessage(Data.prefix + " §a/schematic load <Name>");
                    p.sendMessage(Data.prefix + " §a/schematic delete <Name>");
                }

            }else if(args.length == 2) {

                if(args[0].equalsIgnoreCase("load")) {

                    String name = args[1];
                    Schematic schematic = new Schematic(name);
                    if(schematic.exists()) {
                        schematic.setLocation(p.getLocation());
                        schematic.load();
                        p.sendMessage(Data.prefix + "Du hast die Schematic §b" + name + " §7geladen!");
                    }else {
                        p.sendMessage(Data.prefix + "Diese §bSchematic §7existiert nicht!");
                    }

                }else if(args[0].equalsIgnoreCase("delete")) {

                    String name = args[1];
                    Schematic schematic = new Schematic(name);
                    if(schematic.exists()) {
                        schematic.delete();
                        p.sendMessage(Data.prefix + "Du hast die Schematic §b" + name + " §7gelöscht!");
                    }else {
                        p.sendMessage(Data.prefix + "Diese §bSchematic §7existiert nicht!");
                    }

                }else {
                    p.sendMessage(Data.prefix + "Verwende: ");
                    p.sendMessage(Data.prefix + " §a/schematic list");
                    p.sendMessage(Data.prefix + " §a/schematic create <Name> <Radius>");
                    p.sendMessage(Data.prefix + " §a/schematic load <Name>");
                    p.sendMessage(Data.prefix + " §a/schematic delete <Name>");
                }

            }else if(args.length == 1) {

                if(args[0].equalsIgnoreCase("list")) {
                    Schematic schematic = new Schematic(null);
                    p.sendMessage(Data.prefix + "Liste aller §bSchematics§7:");
                    schematic.listAll().forEach(current -> {
                        p.sendMessage(Data.prefix + "  §a" + current);
                    });
                }else {
                    p.sendMessage(Data.prefix + "Verwende: ");
                    p.sendMessage(Data.prefix + " §a/schematic list");
                    p.sendMessage(Data.prefix + " §a/schematic create <Name> <Radius>");
                    p.sendMessage(Data.prefix + " §a/schematic load <Name>");
                    p.sendMessage(Data.prefix + " §a/schematic delete <Name>");
                }

            }else {
                p.sendMessage(Data.prefix + "Verwende: ");
                p.sendMessage(Data.prefix + " §a/schematic list");
                p.sendMessage(Data.prefix + " §a/schematic create <Name> <Radius>");
                p.sendMessage(Data.prefix + " §a/schematic load <Name>");
                p.sendMessage(Data.prefix + " §a/schematic delete <Name>");
            }

        }


        return false;
    }
}
