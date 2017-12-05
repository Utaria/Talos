package fr.utaria.talos.modules;

import fr.utaria.talos.Talos;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AdaptCPS implements Listener {

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

                        //System.out.println("Minute  = "+ playerinfos.getMCPS());

                        playerinfos.resetTimer();

                    }

                    if(playerinfos.getSCPS() > playerinfos.getTCPS()) {
                        playerinfos.setTCPS(playerinfos.getSCPS());
                    }

                    //System.out.println("Seconde = "+ playerinfos.getSCPS());

                    playerinfos.setSCPS(0);

                }

            }

        }, 0, 20);
    }

}
