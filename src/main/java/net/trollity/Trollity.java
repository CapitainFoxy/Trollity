package net.trollity;

import net.trollity.commands.TrollCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Trollity extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Trollity plugin enabled!");
        saveDefaultConfig(); 
        getCommand("trollity").setExecutor(new TrollCommand(this)); 
    }

    @Override
    public void onDisable() {
        
        getServer();
    }
}
