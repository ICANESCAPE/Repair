package me.alchemy.repair.file;

import me.alchemy.repair.Repair;
import me.alchemy.repair.dto.Data;
import me.xiaolegg.southcore.file.SouthConfiguration;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SCT_Alchemy
 * @date 2018/11/30 6:36 PM
 */

public class Config extends SouthConfiguration {

    private static Config config;

    public Config() { super(Repair.getInstance(), "config.yml"); }
    public static void reload() { config = new Config(); }

    private static List<Data> datas = new ArrayList<>();

    @Override
    public void check() {
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
}
