package HoloExp.Commands;

import HoloExp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadExecutor implements CommandExecutor {

    Main plugin;

    public ReloadExecutor(Main instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getLabel().equalsIgnoreCase("holoexp")) {
            if (strings != null) {
                if (strings[0].equalsIgnoreCase("reload")) {
                    if (commandSender.hasPermission("holoexp.reload")) {
                        plugin.reloadConfig();
                        return true;
                    }
                }
            }
            commandSender.sendMessage(ChatColor.GOLD + "HoloExp");
            commandSender.sendMessage(ChatColor.AQUA + "By GungnirIncarnate");
            return true;
        }
        return false;
    }
}
