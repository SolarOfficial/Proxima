package xyz.solardev.proxima.utils;

import org.bukkit.ChatColor;

public class Chat {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
