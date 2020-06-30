package de.skycentral.sb.main;

import de.skycentral.sb.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public Main instance;

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

    public Main getInstance() {
        return instance;
    }
}
