package maiastudio.me.maiarush.lobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class CairVoid implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player p = event.getPlayer();
        Location loc = p.getLocation();

        if (loc.getBlockY() <= 0){
            String command = "spawn";
            Bukkit.dispatchCommand(p, command);
        }
    }
}
