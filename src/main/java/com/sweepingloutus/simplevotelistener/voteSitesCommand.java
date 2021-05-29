package com.sweepingloutus.simplevotelistener;

import net.md_5.bungee.api.chat.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
            if(player.hasPermission("svl.list")){
                ConfigurationSection configurationSection = main.getConfig().getConfigurationSection("voteCMD.votesites");
                if(configurationSection!=null){
                    Set<String> voteSites = configurationSection.getKeys(false);
                    List<TextComponent> messages = new ArrayList<>();
                    for(String voteSite: voteSites){
                        //String siteName = config.getString("voteCMD.votesites."+ votesite +".name");
                        String siteURL = config.getString("voteCMD.votesites."+ voteSite +".url");
                        String siteHoverText = config.getString("voteCMD.votesites."+ voteSite +".hovertext");
                        String siteHoverTextFormatted = messageFormatter.messageFormat(siteHoverText, player);
                        String siteChatText = config.getString("voteCMD.votesites."+ voteSite +".chattext");
                        String siteChatTextFormatted = messageFormatter.messageFormat(siteChatText,player);

                        TextComponent message = new TextComponent(TextComponent.fromLegacyText(siteChatTextFormatted));
                        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, siteURL));
                        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(siteHoverTextFormatted)));

                        messages.add(message);
                    }

                    String titleLine = messageFormatter.messageFormat(config.getString("voteCMD.titleline"), player);
                    TextComponent formatTitleLine = new TextComponent(TextComponent.fromLegacyText(titleLine));
                    player.spigot().sendMessage(formatTitleLine);
                    for (TextComponent message:messages){
                        player.spigot().sendMessage(message);
                    }
                    return true;
                }else{
                    logger.log(Level.SEVERE,"Please Add sites to config if you want a working help command!");
                }
            }else{
                player.sendMessage("Invalid Permission!");
            }
        }else{
            logger.log(Level.INFO,"You must be a player to run this command!");
        }
        return true;
    }
}
