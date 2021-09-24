package xyz.solardev.proxima;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.solardev.proxima.listeners.HubListener;
import xyz.solardev.proxima.scoreboard.Adapter;
import xyz.solardev.proxima.scoreboard.api.Assemble;
import xyz.solardev.proxima.scoreboard.api.AssembleStyle;

public class Proxima extends JavaPlugin {
    @Getter public static Proxima instance;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        registerScoreboard();
        this.getServer().getPluginManager().registerEvents(new HubListener(), this);
    }

    public void onDisable() {
        instance = null;
    }

    void registerScoreboard() {
        Assemble assemble = new Assemble(this, new Adapter());
        assemble.setTicks(2);
        assemble.setAssembleStyle(AssembleStyle.MODERN);
    }





}
