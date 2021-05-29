package com.sweepingloutus.simplevotelistener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import java.util.logging.Level;
import java.util.logging.Logger;

public class reloadCommand implements CommandExecutor {
    private final Plugin main;

    public reloadCommand(Plugin mainArg) {
        main = mainArg;
    }

    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
        Logger logger = main.getLogger();
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("svl.reload")){
                try{
                    player.sendMessage("Reloading...");
                    main.reloadConfig();
                    player.sendMessage("Success reloaded config!");
                }catch(Exception e){
                    logger.log(Level.SEVERE,"Error reloading config!",e);
                    return true;
                }
            }else {
                player.sendMessage("You don't have permission to use this command!");
            }
        }else{
            try{
                main.reloadConfig();
            }catch(Exception e){
                logger.log(Level.SEVERE,"Error reloading config!",e);
            }
        }
        return true;
    }
}
