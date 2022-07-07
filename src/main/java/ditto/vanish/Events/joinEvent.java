package ditto.vanish.Events;

import ditto.vanish.Main;
import ditto.vanish.Utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class joinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(Main.getVanished().contains(player.getUniqueId().toString())){
            event.setJoinMessage(null);
            player.sendMessage(ChatUtil.colorize("&4You are in vanish and have joined quietly"));
        }
    }
}
