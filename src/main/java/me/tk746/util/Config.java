package me.tk746.util;

import me.tk746.ChatFilter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

public class Config {

    public static List<String> FILTERS;
    public static boolean ENABLED = true;
    public static String PREFIX;
    public static String COMMAND;

    public static void load() {
        ChatFilter instance = ChatFilter.getInstance();
        String path = "config.yml";
        File configFile = new File(instance.getDataFolder(), path);

        if (!configFile.exists()) {
            instance.saveResource(path, false);
        }

        YamlConfiguration defaultFile = YamlConfiguration.loadConfiguration(new InputStreamReader(instance.getResource(path)));
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        config.addDefaults(defaultFile);

        //configuration values are stored here

        ENABLED = config.getBoolean("chatFilter.enabled");
        FILTERS = config.getStringList("chatFilter.filters");
        PREFIX = config.getString("chatFilter.prefix");
        COMMAND = config.getString("chatFilter.command");

    }
}
