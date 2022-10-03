package maiastudio.me.maiarush.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static maiastudio.me.maiarush.MaiaRush.*;
public class Fly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("fly")){
            if (sender.hasPermission("maiarush.fly")) {
                if (sender instanceof Player) {
                    Player p = (Player)sender;
                    if (p.getAllowFlight()) {
                        p.setFlying(false);
                        p.setAllowFlight(false);
                        p.sendMessage(getInstance().getConfig().getString("lobby.flyoffmsg").replace("&", "§"));
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(getInstance().getConfig().getString("lobby.flyonmsg").replace("&", "§"));
                    }
                }
            }
        }
        return false;
    }
}
