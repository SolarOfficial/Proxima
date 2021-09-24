package xyz.solardev.proxima.listeners;

import net.frozenorb.qlib.util.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.solardev.proxima.Proxima;
import xyz.solardev.proxima.utils.Chat;

public class HubListener implements Listener {
    @EventHandler
    public void click(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack itemInHand = e.getPlayer().getItemInHand();
            ItemMeta itemMeta = itemInHand.getItemMeta();
            if (player.getItemInHand().getItemMeta().getDisplayName() == null) {
                return;
            }
            if (player.getItemInHand().getItemMeta().getDisplayName() == null) {
                return;
            }
            String displayName = player.getItemInHand().getItemMeta().getDisplayName();
            boolean server_selector = displayName.contains("Server Selector");
            Material type = itemInHand.getType();
            String name = type.name();
            boolean isCompass = name.contains("BOOK");
            if (server_selector && isCompass) {
                (new BukkitRunnable() {
                    public void run() {
                        //(new Menu()).openMenu(e.getPlayer());
                    }
                }).runTaskLaterAsynchronously(Proxima.getInstance(), 2L);
            } else if (itemInHand.getItemMeta().getDisplayName().contains("Ender Butt") && name.contains("ENDER")) {
                e.setCancelled(true);
                Projectile pearl = player.launchProjectile(EnderPearl.class, player.getLocation().getDirection().multiply(2.0D));
                pearl.setShooter(null);
                e.getPlayer().updateInventory();
                pearl.setPassenger((Entity)player);
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 100.0F, 2.0F);

            }
        }
    }

    @EventHandler
    public void breakernobreaking(BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void placernoplacing(BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void fatboi(FoodLevelChangeEvent event) {
        event.setCancelled(true);

    }

    @EventHandler
    public void droppernodropping(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().setBoots((ItemStack) null);
        e.getPlayer().getInventory().setLeggings((ItemStack) null);
        e.getPlayer().getInventory().setChestplate((ItemStack) null);
        e.getPlayer().getInventory().setHelmet((ItemStack) null);
        e.setJoinMessage((String) null);
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().setHelmet((ItemStack) null);
        e.getPlayer().getInventory().setChestplate((ItemStack) null);
        e.getPlayer().getInventory().setLeggings((ItemStack) null);
        e.getPlayer().getInventory().setBoots((ItemStack) null);
        e.getPlayer().getInventory().setItem(0, ItemBuilder.of(Material.BOOK).name(Chat.format("&eServer Selector")).build());
        e.getPlayer().getInventory().setItem(1, ItemBuilder.of(Material.ENDER_PEARL).name(Chat.format("&eEnder Butt")).amount(16).build());
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        e.getPlayer().setHealth(e.getPlayer().getMaxHealth());
        e.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 773D, 200.0D, -1727D, 0.0F, 0.0F));
        sendJoinMessage(e.getPlayer());
    }

    @EventHandler
    public void idkwhattonamethis(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    public static void sendJoinMessage(Player player) {
        player.sendMessage(Chat.format("&7&m--------------------------------------"));
        player.sendMessage(Chat.format("&r"));
        player.sendMessage(Chat.format("Welcome to the &bExample Network&f"));
        player.sendMessage(Chat.format("&r"));
        player.sendMessage(Chat.format("&r &8* &7Website&7: &6https://example.gg"));
        player.sendMessage(Chat.format("&r &8* &7Store&7: &6https://store.example.gg"));
        player.sendMessage(Chat.format("&r &8* &7Discord&7: &6https://discord.gg/example"));
        player.sendMessage(Chat.format("&r &8* &7Twitter&7: &6https://twitter.com/@Example"));
        player.sendMessage(Chat.format("&r"));
        player.sendMessage(Chat.format("&7&m--------------------------------------"));
    }
}
                        



