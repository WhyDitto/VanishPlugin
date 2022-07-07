package ditto.vanish.Events;


import ditto.vanish.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class pickupEvent implements Listener {
    @EventHandler
    public void onPick(PlayerPickupItemEvent event){
        Player player = event.getPlayer();
        if(Main.getVanished().contains(player.getUniqueId().toString())){
            event.setCancelled(true);
        }
    }
}
