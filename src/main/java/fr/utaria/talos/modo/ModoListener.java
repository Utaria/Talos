package fr.utaria.talos.modo;

import fr.utaria.talos.Talos;
import fr.utaria.talos.menus.ModoInfosMenu;
import fr.utaria.talos.menus.ModoReportsMenu;
import fr.utaria.talos.menus.ModoTeleportationMenu;
import fr.utaria.talos.modules.PlayerInfos;
import fr.utaria.talos.util.ModoUtil;
import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.players.PlayerInfo;
import fr.utaria.utariacore.players.PlayersManager;
import fr.utaria.utariacore.players.UtariaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerInfos playerinfos = new PlayerInfos(player);

        if(!Talos.getPlayers().contains(playerinfos)) {
            Talos.getPlayers().add(playerinfos);
        }

        // On applique directement le grade de Modérateur pour les tests
		PlayerInfo.get(player).setRank(PlayersManager.getRankByName("Modérateur"));
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event){
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


            }
        }

    }

}
