package fr.utaria.talos.modules;

import fr.utaria.talos.PlayerInfo;
import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.data.CPSData;
import fr.utaria.talos.util.CheatConsts;
import fr.utaria.talos.util.DevUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CPS extends AbstractModule {

	public CPS(boolean active) {
		super("CPS", active);
	}

	public void onEnable() {
		this.runTask();
	}

	public void onDisable(){

	}

	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			Talos.getPlayerInfo(event.getPlayer()).getCPSData().incCPS();
		}
	}

	private void runTask() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(Talos.getInstance(), () -> {

            for(PlayerInfo playerInfo : Talos.getPlayers()) {

            	CPSData data = playerInfo.getCPSData();

                data.saveCPS();

                if(data.stateTab()) {
                    data.setCPM(data.getMoyCPS());
                    data.resetTimer();
                }

				if(data.getCPS() > CheatConsts.CPS) {
					System.out.println("CHEAT");
                	if(data.getCPM() > CheatConsts.CPM){
						int dif = data.getCPS() - CheatConsts.CPS;
						playerInfo.incrementViolation(this, dif);
					}
				}

				//DevUtil.sendDebug("CPS : " + data.getCPS());
				System.out.println("Violation : " + playerInfo.getViolation("CPS"));
				System.out.println("CPM : " + data.getCPM());
                if(data.getCPS() > data.getTCPS()) data.setTCPS(data.getCPS());

                data.setCPS(0);

            }

        }, 0, 20);
	}

}
