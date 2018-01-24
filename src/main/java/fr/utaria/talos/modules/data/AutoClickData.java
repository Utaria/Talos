package fr.utaria.talos.modules.data;

import org.bukkit.entity.Player;

public class AutoClickData {

    private Player player;
    private long lastClickTime;
    private long lastGap;
    private long now;
    private long gap;

    public AutoClickData(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public long getLastClickTime() {
        return lastClickTime;
    }

    public void setLastClickTime(long lastClickTime) {
        this.lastClickTime = lastClickTime;
    }

    public long getLastGap() {
        return lastGap;
    }

    public void setLastGap(long lastGap) {
        this.lastGap = lastGap;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getGap() {
        return gap;
    }

    public void setGap(long gap) {
        this.gap = gap;
    }

}
