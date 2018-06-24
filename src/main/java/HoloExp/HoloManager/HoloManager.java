package HoloExp.HoloManager;

import HoloExp.Main;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HoloManager {

    Main plugin;
    public HoloManager(Main instance) {
        plugin = instance;
    }

    public void createHologram(Player player, Location loc, int expAmount) {
        Hologram hologram = HologramsAPI.createHologram(plugin, loc.add(0.5, 1.5, 0.5));
        String name = player.getName();
        String[] strings = plugin.getConfig().getString("Holograms.Holo_msg").split("\\|");
        String holotext;
        for (String s : strings) {
            holotext = ChatColor.translateAlternateColorCodes('&', s.replace("{player}", name).replace("{exp}", String.valueOf(expAmount)));
            hologram.appendTextLine(holotext);
        }
        scheduleHoloDeletion(hologram);

    }

    private void scheduleHoloDeletion(final Hologram hologram) {
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                hologram.delete();
            }
        }, plugin.getConfig().getLong("Holograms.Duration"));
    }

}
