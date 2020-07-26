package com.sweepingloutus.simplevotelistener;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class voteSitesCommand implements CommandExecutor {

    private Plugin main;

    public voteSitesCommand (Plugin mainArg) {
        main = mainArg;
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender sender,@Nonnull Command command, @Nonnull String label,@Nonnull String[] args) {
        FileConfiguration config = main.getConfig();
        Logger logger = main.getLogger();
        if(sender instanceof Player){
            Player player = (Player) sender;

            TextComponent message = new TextComponent ("Click me!");


        }else{
            logger.log(Level.INFO,"You must be a player to run this command!");
        }

        return true;
    }
}
