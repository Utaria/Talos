package fr.utaria.talos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TalosListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Talos.addPlayer(event.getPlayer());
    }

}
