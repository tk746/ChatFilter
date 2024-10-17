package me.tk746.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class Utils {

    //general prefix
    public static final String PREFIX = Config.PREFIX;
    //field to declare console sender
    private static final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    //logs things in console with color
    public static void logColor(String message) {
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
