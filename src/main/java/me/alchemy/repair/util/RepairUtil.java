package me.alchemy.repair.util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import org.sct.core.file.FileTool;

/**
 * @author SCT_Alchemy
 * @date 2018/11/30 6:42 PM
 */

public class RepairUtil {

    public static ItemStack toItem(String name) {
        return FileTool.getItem(name);
    }

    public static String changeColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
