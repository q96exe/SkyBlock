package de.skycentral.sb.main;

import de.skycentral.sb.commands.Island;
import de.skycentral.sb.listener.JQListener;
import de.skycentral.sb.schematic.CMD_schematic;
import de.skycentral.sb.utils.Data;
import de.skycentral.sb.utils.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    private LocationManager locationManager = new LocationManager();

    @Override
    public void onEnable() {
        instance = this;
        init();
        Bukkit.getConsoleSender().sendMessage(Data.prefix + "§aDas Plugin wurde erfolgreich aktiviert");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Data.prefix + "§cDas Plugin wurde erfolgreich deaktiviert");
    }

    private void init() {
        //COMMANDS
        getCommand("schematic").setExecutor(new CMD_schematic());
        getCommand("island").setExecutor(new Island());
        //EVENTS
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JQListener(), this);
    }

    public static Main getInstance() {
        return instance;
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }
}
