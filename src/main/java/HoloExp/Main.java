package HoloExp;

import HoloExp.Commands.RegisterCommands;
import HoloExp.Listeners.RegisterListeners;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        startup();
    }

    public void onDisable() {
        //Remove all holograms (safety)
        for (Hologram hologram : HologramsAPI.getHolograms(this)) {
            hologram.delete();
        }
    }

    private void startup() {

        //Save config
        saveDefaultConfig();

        //Check for Holographic display plugin
        if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
            getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
            getLogger().severe("*** This plugin will be disabled. ***");
            this.setEnabled(false);
            return;
        }

        //Register All Commands
        registerCommands();

        //Register All Listeners
        registerListeners();

    }

    private void registerListeners() {
        //register Listeners
        RegisterListeners rl = new RegisterListeners(this);
        rl.registerListeners();
    }

    private void registerCommands() {
        RegisterCommands registerCommands = new RegisterCommands(this);
        registerCommands.registerCommands();
    }

}
