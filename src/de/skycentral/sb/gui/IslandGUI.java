package de.skycentral.sb.gui;

import de.omel.api.itemstack.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class IslandGUI {

    public IslandGUI() {

    }

    public void openIslandGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 3, "§a§lIsland");

        for(int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)15).build());
        }

        inventory.setItem(10, new ItemBuilder(Material.GRASS).setDisplayname("§a§lIsland Menü").build());

        player.openInventory(inventory);
    }
}
