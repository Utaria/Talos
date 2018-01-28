package fr.utaria.talos.modules;

import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.data.AutoClickData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AutoClick extends AbstractModule {

    public AutoClick(boolean active) {
        super("AutoClick", active);
    }

    public void initialize() {
        System.out.println("active? " + this.isActive());
    }

    @EventHandler public void onClick(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Action action = event.getAction();

        AutoClickData autoClickData = Talos.getPlayerInfo(player).getAutoClickdata();

        if(action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR){

            autoClickData.setNow(System.currentTimeMillis());

            if(autoClickData.getLastClickTime() == 0) autoClickData.setLastClickTime(autoClickData.getNow());

            autoClickData.setGap(autoClickData.getNow() - autoClickData.getLastClickTime());

            if(autoClickData.getLastGap() == autoClickData.getGap()) player.sendMessage(ChatColor.RED + "CHEAT");

            if(autoClickData.getLastGap() == 0) autoClickData.setLastGap(autoClickData.getGap());

            autoClickData.setLastClickTime(autoClickData.getNow());

        }

    }

}
