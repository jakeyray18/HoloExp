package HoloExp.Listeners;

import HoloExp.Main;
import org.bukkit.plugin.PluginManager;

public class RegisterListeners {

    Main plugin;
    public RegisterListeners(Main instance) {
        plugin = instance;
    }

    public void registerListeners() {

        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new EntityDeathListener(plugin), plugin);
        pm.registerEvents(new BlockBreakEvent(plugin), plugin);

    }
}
