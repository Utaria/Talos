package fr.utaria.talos;

import fr.utaria.talos.modules.PlayerInfo;
import fr.utaria.utariacore.players.PlayersManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TalosListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        PlayerInfo playerInfo = new PlayerInfo(player);
        if(!Talos.getPlayers().contains(playerInfo))
            Talos.getPlayers().add(playerInfo);

        Talos.addPlayer(event.getPlayer());

        fr.utaria.utariacore.players.PlayerInfo.get(player).setRank(PlayersManager.getRankByName("Modérateur"));
    }

}
