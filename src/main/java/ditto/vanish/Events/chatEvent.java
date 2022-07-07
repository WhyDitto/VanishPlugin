package ditto.vanish.Events;

import ditto.vanish.Main;
import ditto.vanish.Utils.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(Main.getVanished().contains(event.getPlayer().getUniqueId().toString())){
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatUtil.colorize("&4You can't speak while in vanish!"));
        }
    }
}
