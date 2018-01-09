package fr.utaria.talos.modo;

import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.PlayerInfos;
import fr.utaria.utariacore.players.PlayerInfo;
import fr.utaria.utariacore.players.PlayersManager;
import fr.utaria.utariacore.players.UtariaPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

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
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack current = event.getItem();

        if(event.getAction() == Action.LEFT_CLICK_AIR && event.getAction() == Action.LEFT_CLICK_BLOCK){
            if(current == null) return;

            if(UtariaPlayer.get(player).hasMode("modo"))
                if(current.getType() == Material.COMPASS && current.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Téléportation aux joueurs"))
                    player.sendMessage("Vous avez cliquez sur la boussole !");
        }
    }

}
