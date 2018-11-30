package me.alchemy.repair.util;

import com.qq245949795.aicore.Storage.ItemCache;
import com.qq245949795.aicore.Util.FileTool;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

/**
 * @author SCT_Alchemy
 * @date 2018/11/30 6:42 PM
 */

public class RepairUtil {

    public static ItemStack toItem(String name) {
        return ItemCache.itemMap.get(name);
    }

    public static String changeColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
