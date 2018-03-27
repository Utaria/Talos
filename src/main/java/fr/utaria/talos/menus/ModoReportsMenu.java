package fr.utaria.talos.menus;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.items.StaticMenuItem;

import org.bukkit.entity.Player;

public class ModoReportsMenu extends Menu {

    public ModoReportsMenu(Player player) {
        super("Reports des joueurs", MenuSize.SIX_LINE);
        this.preparer(player);
    }

    private void preparer(Player viewer) {
    	
    }

}
