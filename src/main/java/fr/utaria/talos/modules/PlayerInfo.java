package fr.utaria.talos.modules;

import fr.utaria.talos.modules.data.AutoClickData;
import fr.utaria.talos.modules.data.CPSData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerInfo {

    private Player player;
    private CPSData CPSdata;
    private AutoClickData AutoClickdata;
    private HashMap<AbstractModule, Double> violations = new HashMap<>();

    public PlayerInfo(Player player){
        this.player = player;
        this.CPSdata = new CPSData(this.player);
        this.AutoClickdata = new AutoClickData(this.player);
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

    public void incrementViolation(AbstractModule module, double violation) {
        double value = 0;
        if(violations.containsKey(module))
            value = violations.get(module);
        this.violations.put(module, value + violation);
    }

    public double getViolation(String name) {
        for (Map.Entry<AbstractModule, Double> entry : violations.entrySet()){
            if(entry.getKey().getName().equals(name)) return entry.getValue();
        }
        return 0;
    }

}
