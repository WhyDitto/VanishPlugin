package ditto.vanish.Events;

import ditto.vanish.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class leaveEvent implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(Main.getVanished().contains(player.getUniqueId().toString())){
            event.setQuitMessage(null);
        }
    }
}
