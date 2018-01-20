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
			Talos.getPlayerInfo(event.getPlayer()).getCPSData().incCPS();
		}
	}

	public void runTask() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(Talos.getInstance(), () -> {

            for(PlayerInfo playerInfo : Talos.getPlayers()) {

            	CPSData data = playerInfo.getCPSData();

                data.saveSCPS();

                if(data.stateTab()) {
                    data.setCPM(data.getMoyCPS());
                    data.resetTimer();
                }

				if(data.getCPS() > 5) {
					playerInfo.incrementViolations(this, 1);
					System.out.println(playerInfo.getViolations("CPS"));
				}

                if(data.getCPS() > data.getTCPS()) data.setTCPS(data.getCPS());

                data.setCPS(0);

            }

        }, 0, 20);
	}

}
