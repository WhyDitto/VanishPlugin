package ditto.vanish;

import ditto.vanish.Utils.ChatUtil;
import ditto.vanish.Utils.DataUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class vanishCommand implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("vanishplugin.use")) {
                if (!Main.getVanished().contains(player.getUniqueId().toString())) {
                    Main.getVanished().add(player.getUniqueId().toString());
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.hidePlayer(player);
                        players.sendMessage(ChatColor.YELLOW + player.getDisplayName() + " left the server");
                    }
                    player.sendMessage(ChatUtil.colorize("&4You have been hidden"));
                    DataUtil.getConfig().set("vanished-players", Main.getVanished());
                    DataUtil.saveConfig();
                } else {
                    Main.getVanished().remove(player.getUniqueId().toString());
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.showPlayer(player);
                        players.sendMessage(ChatColor.YELLOW + player.getDisplayName() + " joined the game");
                    }
                    player.sendMessage(ChatUtil.colorize("&aYou are now visible!"));
                    DataUtil.getConfig().set("vanished-players", Main.getVanished());
                    DataUtil.saveConfig();
                }
            }else{
                player.sendMessage(ChatUtil.colorize("&4You don't have permission to run this command!"));
            }


        }
        return true;
    }
}
