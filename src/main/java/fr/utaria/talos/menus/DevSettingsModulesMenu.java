package fr.utaria.talos.menus;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import org.bukkit.entity.Player;

public class DevSettingsModulesMenu extends Menu {
    public DevSettingsModulesMenu(Player player) {
        super("Paramètres des modules", MenuSize.SIX_LINE);
        this.preparer(player);
    }

    private void preparer(Player viewer) {

    }
}
