package HoloExp.Commands;

import HoloExp.Main;

public class RegisterCommands {

    Main plugin;
    public RegisterCommands(Main instance) {
        plugin = instance;
    }

    public void registerCommands() {
        plugin.getCommand("holoexp").setExecutor(new ReloadExecutor(plugin));
    }

}
