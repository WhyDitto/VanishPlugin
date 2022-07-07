package ditto.vanish.Events;

import ditto.vanish.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class targetEvent implements Listener {
    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent event){
        if(event.getTarget() instanceof Player){
            Player target = (Player) event.getTarget();
            if(Main.getVanished().contains(target.getUniqueId().toString())){
                event.setCancelled(true);
                event.setTarget(null);
            }
        }
    }
}
