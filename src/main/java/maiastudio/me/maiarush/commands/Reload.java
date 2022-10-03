package maiastudio.me.maiarush.commands;

import maiastudio.me.maiarush.MaiaRush;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static maiastudio.me.maiarush.MaiaRush.*;

public class Reload implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("maiareload") && p.hasPermission("maiarush.admin")) {
                MaiaRush.getInstance().rlConfig();
                p.sendMessage(getInstance().getConfig().getString("msgrlconfig").replace("&", "§"));
                return true;
            }
        }

        return false;
    }
}
