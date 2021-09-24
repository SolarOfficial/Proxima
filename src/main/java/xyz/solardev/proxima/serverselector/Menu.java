package xyz.solardev.proxima.serverselector;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.frozenorb.qlib.menu.Button;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import xyz.solardev.proxima.Proxima;
import xyz.solardev.proxima.utils.Chat;

import java.util.List;
import java.util.Map;

public class Menu extends net.frozenorb.qlib.menu.Menu {

    private final FileConfiguration fileConfiguration = Proxima.getInstance().getConfig();

    public boolean isAutoUpdate() {
        return true;
    }

    public String getTitle(Player player) {
        return "Server Selector";
    }

    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = Maps.newHashMap();
        buttons.put(12, new Button() {
            public String getName(Player player) {
                return Chat.format("&b&lKitMap");
            }

            public List<String> getDescription(Player player) {
                List<String> description = Lists.newArrayList();
                description.add(Chat.format("&r"));
                description.add(Chat.format("&7Practice your PvP skills with"));
                description.add(Chat.format("&7disposable kits and a free world!"));
                description.add(Chat.format(""));
                description.add(Chat.format("&7» &bCurrent Map: &fMap 1"));
                description.add(Chat.format("&7» &bServer Status: &cOffline"));
                description.add(Chat.format("&r"));
                description.add(Chat.format("&7Click to join the queue!"));
                return description;
            }

            public Material getMaterial(Player player) {
                return Material.BOW;
            }

            public void clicked(Player player, int slot, ClickType clickType) {
                Bukkit.getServer().dispatchCommand(player, "joinqueue kits");
            }

        });
        buttons.put(14, new Button() {
            public String getName(Player player) {
                return Chat.format("&b&lHCFactions");
            }

            public List<String> getDescription(Player player) {
                List<String> description = Lists.newArrayList();
                description.add(Chat.format("&r"));
                description.add(Chat.format("&7Create a team of players and"));
                description.add(Chat.format("&7grind your way to become the best team in the server!"));
                description.add(Chat.format(""));
                description.add(Chat.format("&7» &bCurrent Map: &fMap 1"));
                description.add(Chat.format("&7» &bServer Status: &cOffline"));
                description.add(Chat.format("&r"));
                description.add(Chat.format("&eClick to join the queue!"));
                return description;
            }

            public Material getMaterial(Player player) {
                return Material.DIAMOND_HELMET;
            }

            public void clicked(Player player, int slot, ClickType clickType) {
                Bukkit.getServer().dispatchCommand(player, "joinqueue HCF");


            }
        });
        return buttons;
    }
}