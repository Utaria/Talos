package fr.utaria.talos.dev;

import fr.utaria.talos.util.DevUtil;
import fr.utaria.utariacore.players.PlayersManager;
import fr.utaria.utariacore.players.modes.PlayerMode;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class DevMode extends PlayerMode {

    public DevMode(){
        super("dev", GameMode.SPECTATOR, PlayersManager.getRankByName("Développeur"));
    }

    @Override
    public void onModeActivation(Player player) {
        DevUtil.prepareForDev(player);
    }

    @Override
    public void onModeDesactivation(Player player) {

    }

}
