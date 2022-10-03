package maiastudio.me.maiarush.server;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

import static maiastudio.me.maiarush.MaiaRush.*;

public class Book extends ItemStack implements Listener {

    @EventHandler
    public void ItemJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        PlayerInventory pInv = p.getInventory();
        pInv.clear();
        String bmsg = getInstance().getConfig().getString("itemspawn.book.mensagem");
        String author = getInstance().getConfig().getString("itemspawn.book.author");
        String title = getInstance().getConfig().getString("itemspawn.book.title");
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta bm = (BookMeta) book.getItemMeta();
        bm.addPage(bmsg.replace("&", "§").replace("%line%", "\n"));
        bm.setAuthor(author.replace("&", "§"));
        bm.setTitle(title.replace("&", "§"));
        book.setItemMeta(bm);
        pInv.setItem(4, book);
    }
}
