package ditto.vanish.Utils;

import org.bukkit.ChatColor;

public class ChatUtil {

    public static String colorize(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
