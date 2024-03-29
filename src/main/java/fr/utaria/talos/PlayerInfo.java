package fr.utaria.talos;

import fr.utaria.talos.modules.AbstractModule;
import fr.utaria.talos.modules.data.AutoClickData;
import fr.utaria.talos.modules.data.CPSData;
import fr.utaria.talos.modules.data.FastBreakData;
import fr.utaria.talos.util.SettingsUtil;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerInfo {

    private Player player;
    private CPSData CPSdata;
    private AutoClickData AutoClickdata;
    private FastBreakData FastBreakdata;
    private HashMap<AbstractModule, Double> violations = new HashMap<>();
    private HashMap<String, String> playerSettings = new HashMap<>();

    PlayerInfo(Player player){
        this.player = player;
        this.CPSdata = new CPSData(this.player);
        this.AutoClickdata = new AutoClickData(this.player);
        this.FastBreakdata = new FastBreakData(this.player);
        this.playerSettings = SettingsUtil.getPlayerSettings(player);
    }

    public Player getPlayer(){
        return this.player;
    }

    public CPSData getCPSData(){
        return this.CPSdata;
    }

    public AutoClickData getAutoClickdata(){
        return this.AutoClickdata;
    }

    public FastBreakData getFastBreakdata(){
        return this.FastBreakdata;
    }

    public HashMap<String, String> getPlayerSettings(){
    	return this.playerSettings;
    }
    
    public String getPlayerSetting(String key){
        return this.playerSettings.get(key);
    }
    
    public void setPlayerSetting(String key, String value) {
    	this.playerSettings.put(key, value);
    }

    public void incrementViolation(AbstractModule module, double violation) {
        double value = 0;
        if(violations.containsKey(module))
            value = violations.get(module);
        this.violations.put(module, value + violation);
    }

    public void decrementViolation(AbstractModule module){
        if(violations.containsKey(module)){
            double value = violations.get(module);
            this.violations.put(module, Math.max(value - module.getDecrementViolation(), 0));
        }
    }

    public double getViolation(String name) {
        for (Map.Entry<AbstractModule, Double> entry : violations.entrySet()){
            if(entry.getKey().getName().equals(name)) return entry.getValue();
        }
        return 0;
    }

}
