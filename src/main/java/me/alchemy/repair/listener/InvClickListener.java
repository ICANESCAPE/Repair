package me.alchemy.repair.listener;

import me.alchemy.repair.file.Config;
import me.alchemy.repair.util.RepairUtil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * @author SCT_Alchemy
 * @date 2018/11/30 6:43 PM
 */

public class InvClickListener implements Listener {

    private static String invName = RepairUtil.changeColor("&c&l装备修复");
    private static final int dur = 0;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Inventory inventory = e.getInventory();
        int slot = e.getSlot();

        if (inventory.getName().contains(invName)) {
            if (slot == 31) {
                e.setCancelled(true);
                ItemStack item = inventory.getItem(11);
                ItemStack tool = inventory.getItem(15);
                if (tool.isSimilar(RepairUtil.toItem(Config.getRepair()))) {
                    item.setDurability((short) dur);
                    int amount = tool.getAmount();
                    tool.setAmount(amount - 1);
                    inventory.setItem(11, item);
                    inventory.setItem(15, tool);
                    player.sendMessage(RepairUtil.changeColor("&a修复完成"));
                    Bukkit.getConsoleSender().sendMessage(RepairUtil.changeColor("&f[&c行为记录&f] " + player.getDisplayName() + "修复了物品" + item.getItemMeta().getDisplayName()));
                } else if (tool.isSimilar(RepairUtil.toItem(Config.getUnbreak()))) {
                    if (!item.getItemMeta().hasLore() || !item.getItemMeta().getLore().contains(Config.getUnbreakLore())) {
                        ItemMeta meta = item.getItemMeta();
                        List<String> lore = meta.getLore();
                        lore.add(RepairUtil.changeColor(Config.getUnbreakLore()));
                        meta.setLore(lore);
                        meta.setUnbreakable(true);
                        meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE } );
                        item.setItemMeta(meta);
                        inventory.setItem(11, item);
                        int amount = tool.getAmount();
                        tool.setAmount(amount - 1);
                        inventory.setItem(15, tool);
                        player.sendMessage(RepairUtil.changeColor("&a你成功镶嵌了不朽铭文"));
                    } else {
                        player.sendMessage(RepairUtil.changeColor("&c你已经镶嵌过不朽铭文了"));
                    }
                } else {
                    player.sendMessage(RepairUtil.changeColor("&c这个物品不是不朽铭文/修复石"));
                }
            }
        }
    }
}
