package de.skycentral.sb.schematic;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
        for(int x = -radius; x < radius; x++) {
            for(int y = -radius; y < radius; y++) {
                for(int z = -radius; z < radius; z++) {

                    this.location.add(x, y, z);
                    if(!this.location.getBlock().getType().equals(Material.AIR)) {
                        this.configuration.set(x + ";" + y + ";" + z, this.location.getBlock().getTypeId() + ":" + this.location.getBlock().getData());
                        System.out.println(this.location.getBlock().getType());
                        this.configuration.set("Radius", this.radius);
                    }
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
        int radius = this.configuration.getInt("Radius");
        for(int x = -radius; x < radius; x++) {
            for(int y = -radius; y < radius; y++) {
                for(int z = -radius; z < radius; z++) {
                    if(this.configuration.contains(x + ";" + y + ";" + z)) {
                        this.location.add(x, y, z);
                        String block = this.configuration.getString(x + ";" + y + ";" + z);
                        int id = Integer.valueOf(block.split(":")[0]);
                        byte subid = Byte.valueOf(block.split(":")[1]);
                        this.location.getBlock().setTypeIdAndData(id, subid, true);
                        this.location.subtract(x, y, z);
                    }
                }
            }
        }
    }

    public void delete() {
        this.file.delete();
    }

    public boolean exists() {
        return this.file.exists();
    }

    public ArrayList<String> listAll() {
        ArrayList<String> list = new ArrayList<>();
        File file = new File("plugins/SkyBlock");
        for(File fileList : file.listFiles()) {
            list.add(fileList.getName().replace(".yml", ""));
        }
        return list;
    }
}
