package maiastudio.me.maiarush.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import static maiastudio.me.maiarush.MaiaRush.*;

public class Motd implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){
        e.setMotd(getInstance().getConfig().getString("servermotd").replace("%seta%", "≫").replace("&", "§"));
    }
}
