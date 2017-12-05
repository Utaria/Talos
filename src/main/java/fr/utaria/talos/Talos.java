package fr.utaria.talos;

import fr.utaria.talos.modules.CPS;
import fr.utaria.talos.modules.PlayerInfos;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Talos extends JavaPlugin {

	public static Talos instance;
	public static ArrayList<PlayerInfos> players;

	public static Talos getInstance() {
		return instance;
	}

	public static ArrayList<PlayerInfos> getPlayers() {
		return players;
	}

	public static PlayerInfos getPlayerInfos(Player p) {
		for(PlayerInfos playerinfos : players) {
			if(playerinfos.getPlayer().getUniqueId().equals(p.getUniqueId())) {
				return playerinfos;
			}
		}
		return null;
	}

	@Override
	public void onEnable() {
		// Test
		System.out.println("Juste un petit test!");
		new CPS(this.getConfig().getBoolean("modules.cps"));
	}

	@Override
	public void onDisable() {

	}

}
