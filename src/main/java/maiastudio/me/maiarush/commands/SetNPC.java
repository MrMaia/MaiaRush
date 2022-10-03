package maiastudio.me.maiarush.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import static maiastudio.me.maiarush.MaiaRush.*;

public class SetNPC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("setnpc")){
            if (sender.hasPermission("maiarush.admin")) {
                if (sender instanceof Player) {
                    Player p = (Player)sender;
                    p.sendMessage(getInstance().getConfig().getString("playnpc.msgplaced").replace("&", "§"));
                    PlayNPC(p);
                }
            }
        }
        return false;
    }

    public void PlayNPC(Player p) {
        Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
        villager.setCustomName(getInstance().getConfig().getString("playnpc.npcname").replace("&", "§"));
        villager.setCustomNameVisible(true);
        villager.setAI(false);
    }
}