package maiastudio.me.maiarush.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static maiastudio.me.maiarush.MaiaRush.*;

public class JoinMessage implements Listener {

    @EventHandler
    public void msgJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage("");
        Bukkit.broadcastMessage(getInstance().getConfig().getString("lobby.joinmsg").replace("&", "§").replace("%player%", p.getDisplayName()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("");
        Bukkit.broadcastMessage(getInstance().getConfig().getString("lobby.quitmsg").replace("&", "§").replace("%player%", p.getDisplayName()));
    }
}
