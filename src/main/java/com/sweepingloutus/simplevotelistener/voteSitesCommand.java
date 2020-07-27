package com.sweepingloutus.simplevotelistener;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Map;
import java.util.Set;
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

            //site1
            String site1Name = config.getString("votesites.votesite1.name");
            String site1URL = config.getString("votesites.votesite1.url");

            //site2
            String site2Name = config.getString("votesites.votesite2.name");
            String site2URL = config.getString("votesites.votesite2.url");

            //site3
            String site3Name = config.getString("votesites.votesite3.name");
            String site3URL = config.getString("votesites.votesite3.url");

            //site4
            String site4Name = config.getString("votesites.votesite4.name");
            String site4URL = config.getString("votesites.votesite4.url");

            TextComponent message = new TextComponent(TextComponent.fromLegacyText("Vote Sites"));

            TextComponent message1 = new TextComponent("Site 1: " + site1Name);
            message1.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site1URL));
            message1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Open "+ site1Name + " in your Browser!").create()));

            TextComponent message2 = new TextComponent("Site 2: " + site2Name);
            message2.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site2URL));
            message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Open "+ site2Name + " in your Browser!").create()));

            TextComponent message3 = new TextComponent("Site 3: " + site3Name);
            message3.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site3URL));
            message3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Open "+ site3Name + " in your Browser!").create()));

            TextComponent message4 = new TextComponent("Site 4: " + site4Name);
            message4.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site4URL));
            message4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Open "+ site4Name + " in your Browser!").create()));

            player.spigot().sendMessage(message);
            player.spigot().sendMessage(message1);
            player.spigot().sendMessage(message2);
            player.spigot().sendMessage(message3);
            player.spigot().sendMessage(message4);
            return true;


        }else{
            logger.log(Level.INFO,"You must be a player to run this command!");
        }

        return true;
    }
}
