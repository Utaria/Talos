package fr.utaria.talos.modules.data;

import org.bukkit.entity.Player;

public class FastBreakData {

    private Player player;

    private long lastBreakTime;
    private long gap;

    public FastBreakData(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public long getLastBreakTime(){
        return this.lastBreakTime;
    }

    public void setLastBreakTime(long lastBreakTime) {
        this.lastBreakTime = lastBreakTime;
    }

    public long getGap() {
        return gap;
    }

    public void setGap(long gap) {
        this.gap = gap;
    }

}
