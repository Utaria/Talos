package fr.utaria.talos.menus;

import com.sun.org.apache.xpath.internal.operations.Bool;
import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.PlayerInfo;
import fr.utaria.talos.util.ModoUtil;
import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.helper.DescriptionBuilder;
import fr.utaria.utariacore.menus.items.MenuItem;
import fr.utaria.utariacore.menus.items.StaticMenuItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModoSettingsMenu extends Menu {

    public ModoSettingsMenu(Player player){
        super(ChatColor.GOLD + "Paramètres du mode Modo", MenuSize.ONE_LINE);
        this.preparer(player);
    }

    private void preparer(Player viewer){

        PlayerInfo playerInfo = Talos.getPlayerInfo(viewer);

        boolean reports = Boolean.valueOf(playerInfo.getPlayerSetting("reports"));
        boolean soundsReports = Boolean.valueOf(playerInfo.getPlayerSetting("sound_reports"));

        final String BOOK2_NAME = ChatColor.RED + "Reports";
        final String JUKEBOX_NAME = ChatColor.GREEN + "Sons des notifications des reports";
        final String FIREWORK_NAME = ChatColor.WHITE + "Vitesse de FLY";

        ItemStack book     = new ItemStack(Material.BOOK);
        ItemStack jukeBox  = new ItemStack(Material.JUKEBOX);
        ItemStack fireWork = new ItemStack(Material.FIREWORK);

        DescriptionBuilder bookDb = new DescriptionBuilder();
        DescriptionBuilder jukeBowDb = new DescriptionBuilder();
        DescriptionBuilder fireWorkDb = new DescriptionBuilder();

        if(reports)
            bookDb.append(ChatColor.GREEN + "Activer ✔");
        else
            bookDb.append(ChatColor.RED + "Desactiver ✘");

        StaticMenuItem bookMenuItem = new StaticMenuItem(BOOK2_NAME, book, bookDb.toArray());
        StaticMenuItem jukeBoxMenuItem = new StaticMenuItem(JUKEBOX_NAME, jukeBox);
        StaticMenuItem fireWorkMenuItem = new StaticMenuItem(FIREWORK_NAME, fireWork);

        bookMenuItem.onItemClick(event -> {



            event.setWillUpdate(true);
        });

        this.setItem(0, bookMenuItem);
        this.setItem(1, jukeBoxMenuItem);
        this.setItem(2, fireWorkMenuItem);
    }

}
