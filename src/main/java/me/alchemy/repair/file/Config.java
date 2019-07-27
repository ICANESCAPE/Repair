package me.alchemy.repair.file;

import me.alchemy.repair.Repair;
import me.alchemy.repair.dto.Data;

import org.bukkit.configuration.ConfigurationSection;
import org.inventivetalent.itembuilder.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SCT_Alchemy
 * @date 2018/11/30 6:36 PM
 */

public class Config extends FileUtil {

    private static Config config;

    public Config() { super(Repair.getInstance(), "config.yml"); }

    public static void reload() {
        config = new Config();
        if (config.get("unbreak") == null) {
            config.set("unbreak", "unbreak");
        }
        if (config.get("repair") == null) {
            config.set("repair", "repair");
        }
        if (config.get("unbreaklore") == null) {
            config.set("unbreaklore", "不朽铭文");
        }
        if (config.getConfigurationSection("gui") == null) {
            config.set("gui.1.slot", "0-10");
            config.set("gui.1.item", "kongge");
        }
    }

    private static List<Data> datas = new ArrayList<>();

    @Override
    public void check() {
        if (super.getConfigurationSection("gui") == null) {

        }
        ConfigurationSection cs = this.getConfigurationSection("gui");
        for (String key : cs.getKeys(false)) {
            datas.add(new Data(
                    cs.getString(key + ".slot"),
                    cs.getString(key + ".item")
            ));
        }
    }

    public static List<Data> getDatas() { return datas; }
    public static String getUnbreak() { return config.getString("unbreak"); }
    public static String getRepair() { return config.getString("repair"); }
    public static String getUnbreakLore() { return config.getString("unbreaklore"); }

}
