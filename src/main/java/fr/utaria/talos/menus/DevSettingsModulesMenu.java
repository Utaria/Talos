package fr.utaria.talos.menus;

import fr.utaria.talos.Talos;
import fr.utaria.talos.managers.ModulesManager;
import fr.utaria.talos.modules.AbstractModule;
import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.helper.DescriptionBuilder;
import fr.utaria.utariacore.menus.items.StaticMenuItem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DevSettingsModulesMenu extends Menu {
    public DevSettingsModulesMenu(Player player) {
        super("Paramètres des modules", MenuSize.SIX_LINE);
        this.preparer(player);
    }

    private void preparer(Player viewer) {
    	
    	int i = 0;
    	
    	for(AbstractModule module : Talos.getInstance().getInstance(ModulesManager.class).getModules()) {
    		
            final String activate = ChatColor.GREEN + "Activer " + ChatColor.DARK_GRAY + "(" + ChatColor.BOLD + ChatColor.GREEN + "✔" + ChatColor.RESET + ChatColor.DARK_GRAY + ")";
            final String desactivate = ChatColor.RED + "Desactiver " + ChatColor.DARK_GRAY + "(" + ChatColor.BOLD + ChatColor.RED + "✘" + ChatColor.RESET + ChatColor.DARK_GRAY + ")";
    		
            DescriptionBuilder moduleDb = new DescriptionBuilder();
            
            if(module.isActive())
            	moduleDb.append(activate);
            else
            	moduleDb.append(desactivate);
            
    		StaticMenuItem item = new StaticMenuItem(module.getName(), new ItemStack(Material.IRON_BLOCK), moduleDb.toArray());
    		this.setItem(i, item);
    		
    		item.onItemClick(event -> {
    			if(module.isActive()) {
    				moduleDb.append(desactivate);
    				module.setActive(false);
    			}
    			else {
    				moduleDb.append(activate);
    				module.setActive(true);
    			}
    				
    			
    			this.preparer(event.getPlayer());
    			
    			event.setWillUpdate(true);
    		});
    		
    		i++;
    	}
    }
}
