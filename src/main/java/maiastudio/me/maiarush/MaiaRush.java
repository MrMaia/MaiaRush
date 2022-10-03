package maiastudio.me.maiarush;

import maiastudio.me.maiarush.commands.Fly;
import maiastudio.me.maiarush.commands.Reload;
import maiastudio.me.maiarush.commands.SetNPC;
import maiastudio.me.maiarush.events.JoinMessage;
import maiastudio.me.maiarush.events.fallDamage;
import maiastudio.me.maiarush.events.onJoin;
import maiastudio.me.maiarush.lobby.CairVoid;
import maiastudio.me.maiarush.server.Book;
import maiastudio.me.maiarush.server.Chat;
import maiastudio.me.maiarush.server.Motd;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaiaRush extends JavaPlugin {

    public static Plugin plugin;
    private static MaiaRush instance;

    @Override
    public void onEnable() {
        instance = this;
        loadEvents();
        loadConfiguration();
        loadComands();
    }

    @Override
    public void onDisable() {

    }

    private void loadConfiguration() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public void saveConfig() {
        saveConfig();
    }

    private void loadEvents() {
        Bukkit.getPluginManager().registerEvents(new Book(), this);
        Bukkit.getPluginManager().registerEvents(new onJoin(), this);
        Bukkit.getPluginManager().registerEvents(new CairVoid(), this);
        Bukkit.getPluginManager().registerEvents(new Chat(), this);
        Bukkit.getPluginManager().registerEvents(new Motd(), this);
        Bukkit.getPluginManager().registerEvents(new fallDamage(), this);
        Bukkit.getPluginManager().registerEvents(new JoinMessage(), this);
    }

    private void loadComands() {
        getCommand("maiareload").setExecutor((CommandExecutor)new Reload());
        getCommand("fly").setExecutor((CommandExecutor)new Fly());
        getCommand("setnpc").setExecutor((CommandExecutor)new SetNPC());
    }

    public void rlConfig(){
        reloadConfig();
    }

    public static MaiaRush getInstance() {
        return instance;
    }
}

