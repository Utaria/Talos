package fr.utaria.talos.modules;

import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.data.FastBreakData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class FastBreak extends AbstractModule {

    public FastBreak(boolean active){
        super("FastBreak", active);
    }

    public void initialize() {
        System.out.println("active? " + this.isActive());
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();

        FastBreakData fastBreakData = Talos.getPlayerInfo(player).getFastBreakdata();

        long now = System.currentTimeMillis();

        if(fastBreakData.getLastBreakTime() == 0)
            fastBreakData.setLastBreakTime(now);

        fastBreakData.setGap(now - fastBreakData.getLastBreakTime());

        fastBreakData.setLastBreakTime(now);
    }

}
