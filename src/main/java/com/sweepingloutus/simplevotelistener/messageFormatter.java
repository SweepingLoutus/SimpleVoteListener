package com.sweepingloutus.simplevotelistener;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class messageFormatter {
    public String messageFormat(String message, Player player, String service){
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
}
