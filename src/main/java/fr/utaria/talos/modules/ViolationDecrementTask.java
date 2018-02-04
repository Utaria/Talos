package fr.utaria.talos.modules;

import fr.utaria.talos.Talos;
import fr.utaria.talos.managers.ModulesManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ViolationDecrementTask implements Runnable {

    public ViolationDecrementTask(){
        Bukkit.getScheduler().runTaskTimerAsynchronously(Talos.getInstance(), this, 0, 600);
    }

    @Override
    public void run() {
        for(AbstractModule module : ModulesManager.getModules())
            for(Player player : Bukkit.getOnlinePlayers())
                Talos.getPlayerInfo(player).decrementViolation(module);
    }

}
