package com.sweepingloutus.simplevotelistener;

import net.md_5.bungee.api.chat.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.logging.Level;
import java.util.logging.Logger;

public class voteSitesCommand implements CommandExecutor {

    private final main main;

    public voteSitesCommand (main mainArg) {
        main = mainArg;
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender sender,@Nonnull Command command, @Nonnull String label,@Nonnull String[] args) {
        FileConfiguration config = main.getConfig();
        Logger logger = main.getLogger();
        messageFormatter messageFormatter = main.getMessageFormatter();
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("svl.vote.list")){
                //site1
                String site1Name = config.getString("voteCMD.votesites.votesite1.name");
                String site1URL = config.getString("voteCMD.votesites.votesite1.url");
                String site1HoverText = config.getString("voteCMD.votesites.votesite1.hovertext");
                String site1HoverTextFormatted = messageFormatter.messageFormat(site1HoverText, player);
                String site1ChatText = config.getString("voteCMD.votesites.votesite1.chattext");
                String site1ChatTextFormatted = messageFormatter.messageFormat(site1ChatText,player);

                //site2
                String site2Name = config.getString("voteCMD.votesites.votesite2.name");
                String site2URL = config.getString("voteCMD.votesites.votesite2.url");
                String site2HoverText = config.getString("voteCMD.votesites.votesite2.hovertext");
                String site2HoverTextFormatted = messageFormatter.messageFormat(site2HoverText, player);
                String site2ChatText = config.getString("voteCMD.votesites.votesite2.chattext");
                String site2ChatTextFormatted = messageFormatter.messageFormat(site2ChatText,player);

                //site3
                String site3Name = config.getString("voteCMD.votesites.votesite3.name");
                String site3URL = config.getString("voteCMD.votesites.votesite3.url");
                String site3HoverText = config.getString("voteCMD.votesites.votesite3.hovertext");
                String site3HoverTextFormatted = messageFormatter.messageFormat(site3HoverText, player);
                String site3ChatText = config.getString("voteCMD.votesites.votesite3.chattext");
                String site3ChatTextFormatted = messageFormatter.messageFormat(site3ChatText,player);

                //site4
                String site4Name = config.getString("voteCMD.votesites.votesite4.name");
                String site4URL = config.getString("voteCMD.votesites.votesite4.url");
                String site4HoverText = config.getString("voteCMD.votesites.votesite4.hovertext");
                String site4HoverTextFormatted = messageFormatter.messageFormat(site4HoverText, player);
                String site4ChatText = config.getString("voteCMD.votesites.votesite4.chattext");
                String site4ChatTextFormatted = messageFormatter.messageFormat(site4ChatText,player);

                String titleLine = messageFormatter.messageFormat(config.getString("voteCMD.titleline"), player);

                TextComponent message = new TextComponent(TextComponent.fromLegacyText(titleLine));

                TextComponent message1 = new TextComponent(TextComponent.fromLegacyText(site1ChatTextFormatted));
                message1.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site1URL));
                message1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(site1HoverTextFormatted)));

                TextComponent message2 = new TextComponent(TextComponent.fromLegacyText(site2ChatTextFormatted));
                message2.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site2URL));
                message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(site2HoverTextFormatted)));

                TextComponent message3 = new TextComponent(TextComponent.fromLegacyText(site3ChatTextFormatted));
                message3.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site3URL));
                message3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(site3HoverTextFormatted)));

                TextComponent message4 = new TextComponent(TextComponent.fromLegacyText(site4ChatTextFormatted));
                message4.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, site4URL));
                message4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(site4HoverTextFormatted)));

                player.spigot().sendMessage(message);
                player.spigot().sendMessage(message1);
                player.spigot().sendMessage(message2);
                player.spigot().sendMessage(message3);
                player.spigot().sendMessage(message4);
                return true;
            }else{
                player.sendMessage("Invaild Permission!");
            }

        }else{
            logger.log(Level.INFO,"You must be a player to run this command!");
        }
        return true;
    }
}
