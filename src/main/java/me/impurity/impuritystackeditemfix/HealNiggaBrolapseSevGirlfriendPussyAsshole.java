package me.impurity.impuritystackeditemfix;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealNiggaBrolapseSevGirlfriendPussyAsshole implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;
            player.setHealth(20);
            sender.sendMessage(ChatColor.YELLOW + "GET HEALED NIGGA -SEVGAY6");
        }
        return true;
    }
}
