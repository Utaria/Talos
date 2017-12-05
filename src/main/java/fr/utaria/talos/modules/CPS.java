package fr.utaria.talos.modules;

import fr.utaria.talos.Talos;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CPS extends AbstractModule {

	public CPS(boolean active) {
		super("CPS", active);
		this.runTask();
	}

	public void initialize() {
		System.out.println("active? " + this.isActive());
	}

	@EventHandler
	public void onClick(PlayerInteractEvent event){
		if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			Talos.getPlayerInfos(event.getPlayer()).incSCPS();
		}
	}

	public void runTask() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(Talos.getInstance(), new Runnable() {

			@Override
			public void run() {

				for(PlayerInfos playerinfos : Talos.getPlayers()) {

					playerinfos.saveSCPS();

					if(playerinfos.stateTab()) {
						playerinfos.setMCPS(playerinfos.getMoyCPS());
						playerinfos.resetTimer();
					}

					if(playerinfos.getSCPS() > playerinfos.getTCPS()) {
						playerinfos.setTCPS(playerinfos.getSCPS());
					}

					playerinfos.setSCPS(0);

				}

			}

		}, 0, 20);
	}

}
