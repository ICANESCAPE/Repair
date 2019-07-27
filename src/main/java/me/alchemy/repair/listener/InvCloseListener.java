package me.alchemy.repair.listener;

import me.alchemy.repair.Repair;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class InvCloseListener implements Listener {

    @EventHandler
    void onClose(InventoryCloseEvent e) {
        if (!e.getInventory().getName().contains("装备修复")) { return; }

        String[] slots = Repair.getInstance().getConfig().getString("BlankSlot").split("|");

        if (e.getInventory().getItem(Integer.parseInt(slots[0])) != null) {
            e.getPlayer().getInventory().addItem( new ItemStack[]{ e.getInventory().getItem(Integer.parseInt(slots[0])) } );
        }

        if (e.getInventory().getItem(Integer.parseInt(slots[1])) != null) {
            e.getPlayer().getInventory().addItem( new ItemStack[]{ e.getInventory().getItem(Integer.parseInt(slots[1])) } );
        }

    }
}
