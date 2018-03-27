package fr.utaria.talos.modules.data;

import org.bukkit.entity.Player;

public class CPSData {

    private Player player;

    private int CPS;
    private double CPM;
    private int TCPS;
    private int[] tabCPS = new int[60];
    private int timerCPS = 0;

    private long lastBreakTime;
    private boolean state = false;

    public CPSData(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public int getCPS() {
        return this.CPS;
    }

    public void setCPS(int CPS) {
        this.CPS = CPS;
    }

    public void incCPS() {
        CPS++;
    }

    public double getCPM() {
        return CPM;
    }

    public void setCPM(double CPM) {
        this.CPM = CPM;
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

    public void saveCPS() {
        this.tabCPS[this.timerCPS] = this.CPS;
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
