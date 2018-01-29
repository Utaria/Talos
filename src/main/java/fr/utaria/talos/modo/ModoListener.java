package fr.utaria.talos.modo;

import fr.utaria.talos.Talos;
import fr.utaria.talos.menus.ModoInfosMenu;
import fr.utaria.talos.menus.ModoReportsMenu;
import fr.utaria.talos.menus.ModoSettingsMenu;
import fr.utaria.talos.menus.ModoTeleportationMenu;
import fr.utaria.talos.modules.PlayerInfo;
import fr.utaria.talos.util.ModoUtil;
import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.players.PlayersManager;
import fr.utaria.utariacore.players.UtariaPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ModoListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player     = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();
        Inventory inv     = event.getClickedInventory();

        if(UtariaPlayer.get(player).hasMode("modo")){
            if(inv instanceof PlayerInventory) {
                if(current.getType() == Material.AIR) return;

                //Menu of teleportation
                if(current.getType() == Material.COMPASS && current.getItemMeta().getDisplayName().equals(ModoUtil.COMPASS_NAME)){
                    Menu menu = new ModoTeleportationMenu(player);
                    menu.open(player);
                }

                //Menu of report
                if(current.getType() == Material.BOOK && current.getItemMeta().getDisplayName().equals(ModoUtil.BOOK_NAME)){
                    Menu menu = new ModoReportsMenu(player);
                    menu.open(player);
                }

                //Menu of infos
                if(current.getType() == Material.PAPER && current.getItemMeta().getDisplayName().equals(ModoUtil.PAPER_NAME)){
                    Menu menu = new ModoInfosMenu(player);
                    menu.open(player);
                }

                //Menu of settings
                if(current.getType() == Material.NAME_TAG && current.getItemMeta().getDisplayName().equals(ModoUtil.NAMETAG_NAME)){
                    Menu menu = new ModoSettingsMenu(player);
                    menu.open(player);
                }

            }
        }

    }

}
