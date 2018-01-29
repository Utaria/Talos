package fr.utaria.talos.menus;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import org.bukkit.entity.Player;

public class DevSettingsMenu extends Menu {
    public DevSettingsMenu(Player player) {
        super("Paramètres du mode Dev", MenuSize.ONE_LINE);
        this.preparer(player);
    }

    private void preparer(Player viewer) {

    }
}
