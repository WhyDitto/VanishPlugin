package ditto.vanish;

import ditto.vanish.Events.*;
import ditto.vanish.Utils.DataUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private static Main main;
    private static List<String> vanished = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        DataUtil.setup();
        getServer().getConsoleSender().sendMessage("Vanish Plugin is enabled!");
        getCommand("vanish").setExecutor(new vanishCommand());
        registerEvents();
        if(!DataUtil.getConfig().contains("vanished-players")) {
            DataUtil.getConfig().set("vanished-players", null);
        }
        vanished = DataUtil.getConfig().getStringList("vanished-players");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new targetEvent(), this);
        getServer().getPluginManager().registerEvents(new chatEvent(), this);
        getServer().getPluginManager().registerEvents(new joinEvent(), this);
        getServer().getPluginManager().registerEvents(new leaveEvent(), this);
        getServer().getPluginManager().registerEvents(new damageEvent(), this);
        getServer().getPluginManager().registerEvents(new pickupEvent(), this);

    }
    public static List<String> getVanished(){
        return vanished;
    }
    public static Main getInstance(){
        return main;
    }

}
