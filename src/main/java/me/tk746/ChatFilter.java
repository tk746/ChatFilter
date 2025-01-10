package me.tk746;

import lombok.Getter;
import me.tk746.commands.ReloadFilter;
import me.tk746.events.PlayerChatListner;
import me.tk746.util.Config;
import me.tk746.util.Utils;
import org.bukkit.plugin.java.JavaPlugin;


public final class ChatFilter extends JavaPlugin {

    @Getter
    private static ChatFilter instance;

    @Override
    public void onEnable() {
        //Plugin Startup Logic

        //get instance
        instance = this;

        //load config
        Config.load();

        //events register
        getServer().getPluginManager().registerEvents(new PlayerChatListner(), this);

        //commands register
        getCommand("reloadfilter").setExecutor(new ReloadFilter());


        //start message for logging
        Utils.logColor("&a-------- ChatFilter STARTED --------");
        Utils.logColor("&a-------- Made by Tk746 --------");


        //check for depends

        //check for softdepends
//        if (getServer().getPluginManager().getPlugin("DiscordSRV")!=null) {
//            Utils.logColor("&aDiscordSRV Plugin found! . . . Hooking in!");
//        }
        Utils.logColor("&a-------- --------  --------");
    }

    public void onReload() {
        Config.load();
    }

    @Override
    public void onDisable() {
        //Plugin Shutdown Logic

        Utils.logColor("&a-------- ChatFilter STOPPED --------");
    }

}
