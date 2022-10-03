package maiastudio.me.maiarush.server;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static maiastudio.me.maiarush.MaiaRush.*;

public class Chat implements Listener {

    @EventHandler
    public void Chat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();

        e.setFormat(getInstance().getConfig().getString("chat")
                .replace("%player%", p.getDisplayName())
                .replace("%message%", msg)
                .replace("%seta%", "≫")
                .replace("&", "§"));
    }
}
