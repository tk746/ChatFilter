package me.tk746.events;

import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.DiscordGuildMessagePostProcessEvent;
import me.tk746.ChatFilter;
import me.tk746.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import static me.tk746.util.Utils.PREFIX;


public final class PlayerChatListner implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerChat(PlayerChatEvent e) {
        Player p = e.getPlayer();



        //get list
        for (String keyword : Config.FILTERS) {

            //if message to lowercase (from list not message) contains a keyword from the config.filters
            if (e.getMessage().toLowerCase().contains(keyword)) {
                //cancel it
                e.setCancelled(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', PREFIX + "&eYour Message was filtered."));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Config.COMMAND.replace("{player}", p.getDisplayName()).replace("{message}", e.getMessage()));
                break;
            }
        }


    }

}
