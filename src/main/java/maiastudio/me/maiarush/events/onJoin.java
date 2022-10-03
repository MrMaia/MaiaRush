package maiastudio.me.maiarush.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import static maiastudio.me.maiarush.MaiaRush.*;

public class onJoin implements Listener {

    @EventHandler
    public void breakBock(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!(p.hasPermission("maiarush.admin"))) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void placeBlock(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName() == "world") {
            if (!(p.hasPermission("maiarush.admin"))) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void Title(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Bukkit.dispatchCommand(p, "spawn");
        String title = getInstance().getConfig().getString("lobby.titlejoin");
        String subtitle = getInstance().getConfig().getString("lobby.subtitlejoin");
        p.sendTitle(ChatColor.translateAlternateColorCodes('&', title), ChatColor.translateAlternateColorCodes('&', subtitle).replace("%player%", p.getDisplayName()));
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);

    }

    @EventHandler
    public void noFeed(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void noDropItem(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void noInvClick(InventoryClickEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void noPVP(EntityDamageByEntityEvent e){
        e.setCancelled(true);
    }

}
