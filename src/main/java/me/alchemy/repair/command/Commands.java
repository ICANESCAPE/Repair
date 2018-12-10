package me.alchemy.repair.command;

import me.alchemy.repair.file.Config;
import me.alchemy.repair.gui.GuiBuilder;
import me.alchemy.repair.util.RepairUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author SCT_Alchemy
 * @date 2018/11/30 8:29 PM
 */

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            GuiBuilder.build(player);
        } else {
            Config.reload();
            //sender.sendMessage(RepairUtil.changeColor("&c只有玩家可以使用命令"));
        }
        return false;
    }
}
