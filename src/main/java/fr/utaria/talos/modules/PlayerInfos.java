package fr.utaria.talos.modules;

import org.bukkit.entity.Player;

public class PlayerInfos {

    private Player player;
    private int SCPS; //Click second
    private double MCPS; //Click minute
    private int TCPS; //Top click
    private int[] tabCPS = new int[30];
    private int timerCPS = 0;

    private long lastBreakTime;
    private boolean state = false;

    private boolean isModo = false;

    public boolean isModo() {
        return isModo;
    }

    public void setModo(boolean modo) {
        isModo = modo;
    }

    public PlayerInfos(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getSCPS() {
        return SCPS;
    }

    public void setSCPS(int SCPS) {
        this.SCPS = SCPS;
    }

    public void incSCPS() {
        SCPS++;
    }

    public double getMCPS() {
        return MCPS;
    }

    public void setMCPS(double MCPS) {
        this.MCPS = MCPS;
    }

    public int getTCPS() {
        return TCPS;
    }

    public void setTCPS(int TCPS) {
        this.TCPS = TCPS;
    }

    public int[] getTabCPS() {
        return tabCPS;
    }

    public void saveSCPS() {
        this.tabCPS[this.timerCPS] = this.SCPS;
        this.timerCPS++;
    }

    public boolean stateTab() {
        return this.timerCPS == this.tabCPS.length;
    }

    public double getMoyCPS() {
        double moy = 0;
        for(int i = 0; i < tabCPS.length; i++) {
            moy += tabCPS[i];
        }
        moy = moy / tabCPS.length;
        return moy;
    }

    public void resetTimer() {
        timerCPS = 0;
    }


    public long getLastBreakTime() {
        return lastBreakTime;
    }

    public void setLastBreakTime(long lastBreakTime) {
        this.lastBreakTime = lastBreakTime;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return this.state;
    }

}
