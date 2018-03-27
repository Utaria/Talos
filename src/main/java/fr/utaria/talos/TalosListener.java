package fr.utaria.talos;

import fr.utaria.talos.util.SettingsUtil;
import fr.utaria.utariacore.players.PlayerInfo;
import fr.utaria.utariacore.players.PlayersManager;
import fr.utaria.utariacore.util.TaskUtil;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TalosListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Talos.addPlayer(event.getPlayer());
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
    	TaskUtil.runAsyncTask(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SettingsUtil.savePlayerSettings(event.getPlayer(), Talos.getPlayerInfo(event.getPlayer()).getPlayerSettings());
				System.out.println(Talos.getPlayerInfo(event.getPlayer()).getPlayerSettings());
			}
		});
    }

}
