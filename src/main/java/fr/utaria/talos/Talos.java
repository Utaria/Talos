package fr.utaria.talos;

import fr.utaria.talos.modo.ModoListener;
import fr.utaria.talos.modo.ModoMode;
import fr.utaria.talos.modules.AutoClick;
import fr.utaria.talos.modules.CPS;
import fr.utaria.talos.modules.PlayerInfo;
import fr.utaria.utariacore.UtariaPlugin;
import fr.utaria.utariacore.players.modes.PlayerModes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Talos extends UtariaPlugin {

	public static Talos instance;
	public static ArrayList<PlayerInfo> players;

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

	public static void addPlayer(Player player){
		players.add(new PlayerInfo(player));
	}

	@Override
	public void onEnable() {
		instance = this;
		players = new ArrayList<>();

		// Test
		System.out.println("Juste un petit test!");
		new CPS(this.getConfig().getBoolean("modules.cps"));
		new AutoClick(this.getConfig().getBoolean("module.auto-click"));

		PlayerModes.registerPlayerMode(new ModoMode());

		Bukkit.getPluginManager().registerEvents(new TalosListener(), this);
		Bukkit.getPluginManager().registerEvents(new ModoListener(), this);
	}

	@Override
	public void onDisable() {

	}

}
