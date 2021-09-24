package xyz.solardev.proxima.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.solardev.proxima.Proxima;
import xyz.solardev.proxima.scoreboard.api.AssembleAdapter;
import xyz.solardev.proxima.utils.Chat;

import java.util.ArrayList;
import java.util.List;

public class Adapter implements AssembleAdapter {


    @Override
    public String getTitle(Player player) {
        return Chat.format(Proxima.getInstance().getConfig().getString("scoreboard.title"));
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        int onlinePlayers = Bukkit.getOnlinePlayers().size();
        for(String message : Proxima.getInstance().getConfig().getStringList("scoreboard.lines")) {
            lines.add(Chat.format(message.replace("%playerCount%", "" + onlinePlayers)));
        }
        return lines;
    }
}
