package fr.utaria.talos;

import fr.utaria.talos.modules.CPS;
import org.bukkit.plugin.java.JavaPlugin;

public class Talos extends JavaPlugin {

	@Override
	public void onEnable() {
		// Test
		new CPS(this.getConfig().getBoolean("modules.cps"));
	}

	@Override
	public void onDisable() {

	}

}
