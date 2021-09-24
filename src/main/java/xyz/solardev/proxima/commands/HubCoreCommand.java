package xyz.solardev.proxima.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.solardev.proxima.Proxima;
import xyz.solardev.proxima.utils.Chat;

import java.util.logging.Handler;

public class HubCoreCommand implements CommandExecutor {


    private Proxima plugin;

    public HubCoreCommand(Proxima plugin){
        this.plugin = plugin;
        plugin.getCommand("hubcore").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can only execute this command as a player!");
            return true;
        }

        Player p = (Player) sender;
        p.sendMessage(Chat.format("&7&m--------------------------------------"));
        p.sendMessage(Chat.format("&r"));
        p.sendMessage(Chat.format("&fThis server is running &3&lProxima Hub Core&f!"));
        p.sendMessage(Chat.format("&r"));
        p.sendMessage(Chat.format("&r &7Thanks for using Proxima Hub Core"));
        p.sendMessage(Chat.format("&r &7Version: &f1.0"));
        p.sendMessage(Chat.format("&r"));
        p.sendMessage(Chat.format("&7&m--------------------------------------"));

        return false;

    }
}
