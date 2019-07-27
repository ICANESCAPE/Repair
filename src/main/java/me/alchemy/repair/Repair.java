package me.alchemy.repair;

import me.alchemy.repair.command.Commands;
import me.alchemy.repair.file.Config;
import me.alchemy.repair.listener.InvClickListener;
import me.alchemy.repair.listener.InvCloseListener;
import me.alchemy.repair.util.RepairUtil;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Repair extends JavaPlugin {

    private static Repair instance;

    @Override
    public void onEnable() {
        instance = this;
        Config.reload();
        Bukkit.getPluginCommand("repair").setExecutor(new Commands());
        Bukkit.getPluginManager().registerEvents(new InvClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new InvCloseListener(), this);
        Bukkit.getConsoleSender().sendMessage(RepairUtil.changeColor("&f[&eRepair插件&f] &6> &f加载完成"));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(RepairUtil.changeColor("&f[&eRepair插件&f] &6> &f卸载完成"));
    }

    public static Repair getInstance() { return instance; }
}
