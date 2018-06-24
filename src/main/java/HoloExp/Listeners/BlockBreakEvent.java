package HoloExp.Listeners;

import HoloExp.HoloManager.HoloManager;
import HoloExp.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {

    Main plugin;
    public BlockBreakEvent(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onBlockBreakEvent(org.bukkit.event.block.BlockBreakEvent event) {
        if (plugin.getConfig().getBoolean("Holograms.Blocks")) {
            if (event.getExpToDrop() > 0) {
                HoloManager holoManager = new HoloManager(plugin);
                holoManager.createHologram(event.getPlayer(), event.getBlock().getLocation(), event.getExpToDrop());
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Holograms.Chat_msg")));
                event.setExpToDrop(0);
            }
        }
    }

}
