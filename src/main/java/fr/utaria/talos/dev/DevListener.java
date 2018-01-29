package fr.utaria.talos.dev;

import fr.utaria.talos.menus.DevSettingsMenu;
import fr.utaria.talos.menus.DevSettingsModulesMenu;
import fr.utaria.talos.util.DevUtil;
import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.players.UtariaPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class DevListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player     = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();
        Inventory inv     = event.getClickedInventory();

        if(UtariaPlayer.get(player).hasMode("dev")){
            if(inv instanceof PlayerInventory){
                if(current.getType() == Material.AIR) return;

                //Menu settings of the modules
                if(current.getType() == Material.CHEST && current.getItemMeta().getDisplayName().equals(DevUtil.CHEST_NAME)){
                    Menu menu = new DevSettingsModulesMenu(player);
                    menu.open(player);
                }

                //Menu of settings
                if(current.getType() == Material.NAME_TAG && current.getItemMeta().getDisplayName().equals(DevUtil.NAMETAG_NAME)){
                    Menu menu = new DevSettingsMenu(player);
                    menu.open(player);
                }

            }
        }
    }

}
