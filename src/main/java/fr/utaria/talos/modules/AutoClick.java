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

        AutoClickData AutoClickData = Talos.getPlayerInfo(player).getAutoClickdata();

        if(action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR){

            AutoClickData.setNow(System.currentTimeMillis());

            if(AutoClickData.getLastClickTime() == 0) AutoClickData.setLastClickTime(AutoClickData.getNow());

            AutoClickData.setGap(AutoClickData.getNow() - AutoClickData.getLastClickTime());

            if(AutoClickData.getLastGap() == AutoClickData.getGap()) player.sendMessage(ChatColor.RED + "CHEAT");

            if(AutoClickData.getLastGap() == 0) AutoClickData.setLastGap(AutoClickData.getGap());

            AutoClickData.setLastClickTime(AutoClickData.getNow());

        }

    }

}
