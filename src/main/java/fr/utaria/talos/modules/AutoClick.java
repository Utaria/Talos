package fr.utaria.talos.modules;

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


    private long lastClickTime;
    private long lastGap;

    @EventHandler public void onClick(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Action action = event.getAction();

        if(action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR){

            long now = System.currentTimeMillis();

            if(this.lastClickTime == 0) this.lastClickTime = now;

            long gap = now - lastClickTime;

            if(this.lastGap == gap) player.sendMessage(ChatColor.RED + "CHEAT");

            if(this.lastGap == 0) this.lastGap = gap;

            this.lastClickTime = now;

        }

    }

}
