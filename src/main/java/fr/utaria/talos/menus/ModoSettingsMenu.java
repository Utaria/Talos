package fr.utaria.talos.menus;

import fr.utaria.talos.Talos;
import fr.utaria.talos.PlayerInfo;
import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.helper.DescriptionBuilder;
import fr.utaria.utariacore.menus.items.StaticMenuItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ModoSettingsMenu extends Menu {

    public ModoSettingsMenu(Player player){
        super(ChatColor.GOLD + "Paramètres du mode Modo", MenuSize.ONE_LINE);
        this.preparer(player);
    }
    
    private void preparer(Player viewer){

        PlayerInfo playerInfo = Talos.getPlayerInfo(viewer);

        boolean reports = Boolean.valueOf(playerInfo.getPlayerSetting("reports"));
        boolean soundReports = Boolean.valueOf(playerInfo.getPlayerSetting("sound_reports"));

        final String BOOK2_NAME = ChatColor.AQUA + "Reports";
        final String JUKEBOX_NAME = ChatColor.DARK_GREEN + "Sons des notifications des reports";
        final String FIREWORK_NAME = ChatColor.WHITE + "Vitesse de FLY";

        ItemStack book     = new ItemStack(Material.BOOK);
        ItemStack jukeBox  = new ItemStack(Material.JUKEBOX);
        ItemStack fireWork = new ItemStack(Material.FIREWORK);

        DescriptionBuilder bookDb = new DescriptionBuilder();
        DescriptionBuilder jukeBoxDb = new DescriptionBuilder();
        DescriptionBuilder fireWorkDb = new DescriptionBuilder();

        final String activate = ChatColor.GREEN + "Activer " + ChatColor.DARK_GRAY + "(" + ChatColor.BOLD + ChatColor.GREEN + "✔" + ChatColor.RESET + ChatColor.DARK_GRAY + ")";
        final String desactivate = ChatColor.RED + "Desactiver " + ChatColor.DARK_GRAY + "(" + ChatColor.BOLD + ChatColor.RED + "✘" + ChatColor.RESET + ChatColor.DARK_GRAY + ")";

        if(reports)
            bookDb.append(activate);
        else
            bookDb.append(desactivate);

        if(soundReports)
            jukeBoxDb.append(activate);
        else
            jukeBoxDb.append(desactivate);
        
        fireWorkDb.append(ChatColor.GOLD + "SOON");
        
        StaticMenuItem bookMenuItem = new StaticMenuItem(BOOK2_NAME, book, bookDb.toArray());
        StaticMenuItem jukeBoxMenuItem = new StaticMenuItem(JUKEBOX_NAME, jukeBox, jukeBoxDb.toArray());
        StaticMenuItem fireWorkMenuItem = new StaticMenuItem(FIREWORK_NAME, fireWork);
        
        bookMenuItem.onItemClick(event -> {
        	if(reports)
        		playerInfo.setPlayerSetting("reports", "false");
        	else
        		playerInfo.setPlayerSetting("reports", "true");
        	
        	this.preparer(viewer);
        	
        	event.setWillUpdate(true);
        });
        
        jukeBoxMenuItem.onItemClick(event -> {
        	if(soundReports)
        		playerInfo.setPlayerSetting("sound_reports", "false");
        	else
        		playerInfo.setPlayerSetting("sound_reports", "true");
        	
        	this.preparer(viewer);
        	
        	event.setWillUpdate(true);
        });

        this.setItem(0, bookMenuItem);
        this.setItem(1, jukeBoxMenuItem);
        this.setItem(2, fireWorkMenuItem);
    }

}
