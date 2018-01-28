package fr.utaria.talos.menus;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import org.bukkit.entity.Player;

public class ModoSettingsMenu extends Menu {

    public ModoSettingsMenu(Player player){
        super("Paramètres du mode Modo", MenuSize.ONE_LINE);
        this.preparer(player);
    }

    private void preparer(Player viewer){

    }

}
