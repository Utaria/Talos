package fr.utaria.talos;

import fr.utaria.talos.dev.DevListener;
import fr.utaria.talos.dev.DevMode;
import fr.utaria.talos.modo.ModoListener;
import fr.utaria.talos.modo.ModoMode;
import fr.utaria.talos.modules.AutoClick;
import fr.utaria.talos.modules.CPS;
import fr.utaria.talos.modules.FastBreak;
import fr.utaria.utariacore.UtariaPlugin;
import fr.utaria.utariacore.players.modes.PlayerModes;
import fr.utaria.utariadatabase.database.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Talos extends UtariaPlugin {

	private static Talos instance;
	private static ArrayList<PlayerInfo> players;

	public static Talos getInstance() {
		return instance;
	}

	public static ArrayList<PlayerInfo> getPlayers() {
		return players;
	}

	public static PlayerInfo getPlayerInfo(Player player) {
		for(PlayerInfo playerinfos : players) {
			if(playerinfos.getPlayer().getUniqueId().equals(player.getUniqueId())) {
				return playerinfos;
			}
		}
		return null;
	}

	static void addPlayer(Player player){
		players.add(new PlayerInfo(player));
	}

	@Override
	public void onEnable() {
		instance = this;
		players = new ArrayList<>();

		new CPS(true);
		new AutoClick(false);
		new FastBreak(false);

		PlayerModes.registerPlayerMode(new ModoMode());
		PlayerModes.registerPlayerMode(new DevMode());

		Bukkit.getPluginManager().registerEvents(new TalosListener(), this);
		Bukkit.getPluginManager().registerEvents(new ModoListener(), this);
		Bukkit.getPluginManager().registerEvents(new DevListener(), this);

		DatabaseManager.registerDatabase("talos");
	}

	@Override
	public void onDisable() {

	}

}
