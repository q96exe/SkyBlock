package de.skycentral.sb.schematic;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class Schematic {

    private Location location;
    private String name;
    private File file;
    private FileConfiguration configuration;
    private int radius;

    public Schematic(String name) {
        this.name = name;
        this.file = new File("plugins/SkyBlock", this.name + ".yml");
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public void save() {
        for(int x = location.getBlockX()-radius; x < location.getBlockX()+radius; x++) {
            for(int y = location.getBlockX()-radius; y < location.getBlockX()+radius; y++) {
                for(int z = location.getBlockX()-radius; z < location.getBlockX()+radius; z++) {

                    this.location.add(x, y, z);
                    this.configuration.set(x + ";" + y + ";" + z, this.location.getBlock().getTypeId() + "|" + this.location.getBlock().getData());
                    this.location.subtract(x, y, z);

                }
            }
        }
        try {
            this.configuration.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        for(int x = location.getBlockX()-radius; x < location.getBlockX()+radius; x++) {
            for(int y = location.getBlockX()-radius; y < location.getBlockX()+radius; y++) {
                for(int z = location.getBlockX()-radius; z < location.getBlockX()+radius; z++) {

                    this.location.add(x, y, z);
                    String block = this.configuration.getString(x + ";" + y + ";" + z);
                    int id = Integer.valueOf(block.split("|")[0]);
                    byte subid = Byte.valueOf(block.split("|")[1]);
                    this.location.getBlock().setTypeIdAndData(id, subid, true);
                    this.location.subtract(x, y, z);

                }
            }
        }
    }





}
