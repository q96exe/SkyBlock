package de.skycentral.sb.main;

import de.skycentral.sb.utils.Data;
import de.skycentral.sb.utils.LocationManager;
import org.bukkit.Bukkit;
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

        //EVENTS

    }

    public static Main getInstance() {
        return instance;
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }
}
