package fr.utaria.talos.modules;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerInfo {

    private Player player;
    private CPSData data;
    private HashMap<AbstractModule, Double> violations = new HashMap<>();

    public PlayerInfo(Player player){
        this.player = player;
        this.data = new CPSData(this.player);
    }

    public Player getPlayer(){
        return this.player;
    }

    public CPSData getCPSData(){
        return this.data;
    }

    public void incrementViolations(AbstractModule module, double violation) {
        double value = 0;
        if(violations.containsKey(module))
            value = violations.get(module);
        this.violations.put(module, value + violation);
    }

    public double getViolations(String name) {
        for (Map.Entry<AbstractModule, Double> entry : violations.entrySet()){
            if(entry.getKey().equals(name)) return entry.getValue();
        }
        return 0;
    }

}
