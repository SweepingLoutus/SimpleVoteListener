package com.sweepingloutus.simplevotelistener;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class onPlayerJoin implements Listener {

    private main main;
    public onPlayerJoin(main mainArg) {
        main = mainArg;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){

        messageFormatter messageFormatter = main.getMessageFormatter();
        FileConfiguration config = main.getConfig();
        Logger logger = main.getLogger();
        Player player = event.getPlayer();

        String reminderMessage = config.getString("reminder_message");
        String formattedReminderMessage = messageFormatter.MessageFormat(reminderMessage,player);

        TextComponent finalMessage = new TextComponent (TextComponent.fromLegacyText(formattedReminderMessage));
        finalMessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vote"));

        String reminderMessageHover = main.getConfig().getString("reminder_message_hover");
        String formattedReminderMessageHover = messageFormatter.MessageFormat(reminderMessageHover,player);

        finalMessage.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new ComponentBuilder(formattedReminderMessageHover).create()));
        player.spigot().sendMessage(finalMessage);


    }
}
