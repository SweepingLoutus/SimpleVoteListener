package com.sweepingloutus.simplevotelistener;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class messageFormatter {

    private final main main;

    public messageFormatter (main mainArg) {
        main = mainArg;
    }

    public String voteMessageFormat(String message, Player player, String service){
        String replacePlayer = message.replaceAll("\\(player\\)",player.getName());
        String replaceService = replacePlayer.replaceAll("\\(service\\)",service);
        String PlaceHolderAPI = PlaceholderAPI.setPlaceholders(player,replaceService);
        return ChatColor.translateAlternateColorCodes('&', PlaceHolderAPI);
    }
    public String placeholderFormat(String message, Player player, String service) {
        String replacePlayer = message.replaceAll("\\(player\\)", player.getName());
        String replaceService = replacePlayer.replaceAll("\\(service\\)", service);
        return PlaceholderAPI.setPlaceholders(player, replaceService);
    }
    public String messageFormat(String message, Player player){
        String PlaceHolderAPI = PlaceholderAPI.setPlaceholders(player,message);
        return ChatColor.translateAlternateColorCodes('&', PlaceHolderAPI);
    }
    public void voteCmdSender(List<TextComponent> messages, Player player){
        FileConfiguration config = main.getConfig();
        String titleLine = messageFormat(config.getString("voteCMD.titleline"), player);
        TextComponent formatTitleLine = new TextComponent(TextComponent.fromLegacyText(titleLine));
        player.spigot().sendMessage(formatTitleLine);
        for (TextComponent message:messages){
            player.spigot().sendMessage(message);
        }
    }
}
