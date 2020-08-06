package com.sweepingloutus.simplevotelistener;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class votifierEvent implements Listener {

    private main main;
    public votifierEvent(main mainArg) {
        main = mainArg;
    }


    @EventHandler(priority= EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event){

        Logger logger = main.getLogger();
        FileConfiguration config = main.getConfig();
        messageFormatter messageFormatter = main.getMessageFormatter();

        String message_to_user = config.getString("message_to_user");
        String broadcast_message = config.getString("broadcast_message");
        List<String> commands = config.getStringList("commands");

        Vote vote = event.getVote();
        String username = vote.getUsername();
        Player player = Bukkit.getPlayer(username);

        if (player != null) {
            String service = vote.getServiceName();

            String userMessageFormatted = messageFormatter.voteMessageFormat(message_to_user,player,service);
            player.sendMessage(userMessageFormatted);

            String broadcastMessageFormatted = messageFormatter.voteMessageFormat(broadcast_message,player,service);
            Bukkit.broadcastMessage(broadcastMessageFormatted);

            for(String command : commands){
                String formattedCommand = messageFormatter.placeholderFormat(command,player,service);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), formattedCommand);
            }
        } else {
            logger.log(Level.INFO,username + " couldn't be found ditching vote!");
        }

    }

}
