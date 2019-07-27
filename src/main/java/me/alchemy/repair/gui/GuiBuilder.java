package me.alchemy.repair.gui;

import me.alchemy.repair.dto.Data;
import me.alchemy.repair.file.Config;
import me.alchemy.repair.util.RepairUtil;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;

/**
 * @author SCT_Alchemy
 * @date 2018/11/30 6:39 PM
 */

public class GuiBuilder {

    private static Inventory inventory;
    private static final String split = "-";

    public static void build(Player player) {
        inventory = Bukkit.createInventory(null, 45, RepairUtil.changeColor("&c&l装备修复"));
        add();
        player.closeInventory();
        player.openInventory(inventory);
    }

    private static void add() {
        List<Data> list = Config.getDatas();
        for (int i = 0; i < list.size(); i++) {
            String slots = list.get(i).getSlot();
            int slot;
            try {
                slot = Integer.parseInt(slots);
                inventory.setItem(slot, RepairUtil.toItem(list.get(i).getItem()));
            } catch (NumberFormatException e) {
                for (int a = Integer.parseInt(slots.split(split)[0]); a < Integer.parseInt(slots.split(split)[1]); a++) {
                    inventory.setItem(a, RepairUtil.toItem(list.get(i).getItem()));
                }
            }
            inventory.setItem(31, RepairUtil.toItem("queren"));
        }
    }
}
