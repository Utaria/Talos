package fr.utaria.talos;

import fr.utaria.talos.commands.ModoCommand;
import fr.utaria.talos.modo.ModoListener;
import fr.utaria.talos.modules.CPS;
import fr.utaria.talos.modules.PlayerInfos;
import fr.utaria.utariacore.UtariaPlugin;
import fr.utaria.utariadatabase.database.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Talos extends UtariaPlugin {

	public static Talos instance;
	public static ArrayList<PlayerInfos> players;
	public static ArrayList<UUID> modPlayers;

	public static Talos getInstance() {
		return instance;
	}

	public static ArrayList<PlayerInfos> getPlayers() {
		return players;
	}

	public static ArrayList<UUID> getModPlayers() {
		return modPlayers;
	}

	public static PlayerInfos getPlayerInfos(Player p) {
		for(PlayerInfos playerinfos : players) {
			if(playerinfos.getPlayer().getUniqueId().equals(p.getUniqueId())) {
				return playerinfos;
			}
		}
		return null;
	}

	public static void addPlayer(Player player){
		players.add(new PlayerInfos(player));
	}

	@Override
	public void onEnable() {
		instance = this;
		players = new ArrayList<>();
		modPlayers = new ArrayList<>();

		// Test
		System.out.println("Juste un petit test!");
		new CPS(this.getConfig().getBoolean("modules.cps"));

		this.getCommand("m").setExecutor(new ModoCommand());

		DatabaseManager.registerDatabase("talos");

		Bukkit.getPluginManager().registerEvents(new TalosListener(), this);
		Bukkit.getPluginManager().registerEvents(new ModoListener(), this);
	}

	@Override
	public void onDisable() {

	}

}
