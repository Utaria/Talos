package fr.utaria.talos.modo;

import fr.utaria.talos.util.ModoUtil;
import fr.utaria.utariacore.players.PlayerInfo;
import fr.utaria.utariacore.players.modes.PlayerMode;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class ModoMode extends PlayerMode {

    public ModoMode() {
        super("modo", GameMode.SPECTATOR, 30);
    }

    @Override
    public void onModeActivation(Player player) {
        ModoUtil.prepareForModo(player);
    }

    @Override
    public void onModeDesactivation(Player player) { }
}
