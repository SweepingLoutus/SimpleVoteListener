package com.sweepingloutus.simplevotelistener;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    private messageFormatter messageFormatter;

    public messageFormatter getMessageFormatter() {
        return messageFormatter;
    }

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            saveDefaultConfig();
            getServer().getPluginManager().registerEvents(new votifierEvent(this), this);
            messageFormatter = new messageFormatter();
            getCommand("vote").setExecutor(new voteSitesCommand(this));
            if(config.getBoolean("vote_reminder")){
                getServer().getPluginManager().registerEvents(new onPlayerJoin(this), this);
            }
        }else{
            throw new RuntimeException("Could not find PlaceholderAPI!! Plugin can not work without it!");
        }
    }

    @Override
    public void onDisable() {

    }
}
