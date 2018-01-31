package fr.utaria.talos;

import fr.utaria.utariacore.players.PlayerInfo;
import fr.utaria.utariacore.players.PlayersManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TalosListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        Talos.addPlayer(event.getPlayer());

        PlayerInfo.get(player).setRank(PlayersManager.getRankByName("Modérateur"));
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        System.out.println(PlayerInfo.get(player).getId());
    }

}
