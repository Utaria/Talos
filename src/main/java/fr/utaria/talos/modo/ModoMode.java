package fr.utaria.talos.modo;

import fr.utaria.talos.util.ModoUtil;
import fr.utaria.utariacore.players.modes.PlayerMode;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class ModoMode extends PlayerMode {

    public ModoMode() {
        super("modo", 30, GameMode.SPECTATOR);
    }

    @Override
    public void onModeActivation(Player player) {
        ModoUtil.prepareForModo(player);
    }

    @Override
    public void onModeDesactivation(Player player) { }
}
