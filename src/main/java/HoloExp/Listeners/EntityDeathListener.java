package HoloExp.Listeners;

import HoloExp.ExperienceManager.ExperienceManager;
import HoloExp.HoloManager.HoloManager;
import HoloExp.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener implements Listener {

    Main plugin;
    public EntityDeathListener(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void EntityDeathEvent(EntityDeathEvent event) {
        if (plugin.getConfig().getBoolean("Holograms.Animals")) {
            if (plugin.getConfig().getStringList("Animals").contains(event.getEntityType().toString().toUpperCase())) {
                if (event.getEntity().getKiller() != null) {
                    HoloManager holoManager = new HoloManager(plugin);
                    holoManager.createHologram(event.getEntity().getKiller(), event.getEntity().getLocation(), event.getDroppedExp());
                    ExperienceManager experienceManager = new ExperienceManager(event.getEntity().getKiller());
                    experienceManager.changeExp(event.getDroppedExp());
                    event.getEntity().getKiller().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Holograms.Chat_msg")));
                }
                event.setDroppedExp(0);
                return;
            }
        }
        if (plugin.getConfig().getBoolean("Holograms.Monsters")) {
            if (plugin.getConfig().getStringList("Monsters").contains(event.getEntityType().toString().toUpperCase())) {
                if (event.getEntity().getKiller() != null) {
                    HoloManager holoManager = new HoloManager(plugin);
                    holoManager.createHologram(event.getEntity().getKiller(), event.getEntity().getLocation(), event.getDroppedExp());
                    ExperienceManager experienceManager = new ExperienceManager(event.getEntity().getKiller());
                    experienceManager.changeExp(event.getDroppedExp());
                    event.getEntity().getKiller().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Holograms.Chat_msg")));
                }
                event.setDroppedExp(0);
                return;
            }
        }
    }


}
