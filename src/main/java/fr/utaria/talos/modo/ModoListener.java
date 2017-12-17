package fr.utaria.talos.modo;

import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.PlayerInfos;
import fr.utaria.talos.util.ModoUtil;
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
    public void onInteractInventory(InventoryClickEvent event) {
        Player player     = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();
        Inventory inv     = event.getInventory();

        if (Talos.getModPlayers().contains(player.getUniqueId())) {
            if(inv instanceof PlayerInventory) {
                if(current.getType() == Material.AIR) return;

                //TOOL BAR
                if(current.getType() == Material.COMPASS && current.getItemMeta().getDisplayName().equals(ModoUtil.COMPASS_NAME)) {
                    Inventory menu = ModoUtil.createInventoryMenu("Téléportation", 54);
                    ModoUtil.fillInventoryMenuOfPlayers(menu);
                    ModoUtil.openInventoryMenu(menu, player);
                }

                if(current.getType() == Material.BOOK && current.getItemMeta().getDisplayName().equals(ModoUtil.BOOK_NAME)) {
                    Inventory menu = ModoUtil.createInventoryMenu("Reports", 54);
                    //ModoUtil.openInventoryMenu(menu);
                }

                if(current.getType() == Material.PAPER && current.getItemMeta().getDisplayName().equals(ModoUtil.PAPER_NAME)) {
                    Inventory menu = ModoUtil.createInventoryMenu("Infos", 54);
                    ModoUtil.fillInventoryMenuOfPlayers(menu);
                    ModoUtil.openInventoryMenu(menu, player);
                }
            }

            //MENUS
            if(current.getType() == Material.SKULL_ITEM && inv.getName().equals("Téléportation")) {
                String playerName = ChatColor.stripColor(current.getItemMeta().getDisplayName());
                player.teleport(Bukkit.getPlayer(playerName));
            }

            if(current.getType() ==  Material.SKULL_ITEM && inv.getName().equals("Infos")) {
                Inventory menu = ModoUtil.createInventoryMenu("Infos du joueur : " + current.getItemMeta().getDisplayName(), 9);
                ModoUtil.fillInventoryMenuInfos(menu);
                ModoUtil.openInventoryMenu(menu, player);
            }

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerInfos playerinfos = new PlayerInfos(player);
        if(!Talos.getPlayers().contains(playerinfos)) {
            Talos.getPlayers().add(playerinfos);
        }
    }

}
