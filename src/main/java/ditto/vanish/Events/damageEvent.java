package ditto.vanish.Events;

import ditto.vanish.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class damageEvent implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(Main.getVanished().contains(player.getUniqueId().toString())){
                event.setCancelled(true);
            }
        }
    }
}
