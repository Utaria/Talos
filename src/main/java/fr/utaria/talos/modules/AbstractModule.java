package fr.utaria.talos.modules;

import fr.utaria.talos.Talos;
import fr.utaria.talos.util.TalosUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class AbstractModule implements Listener {

	private String name;
	private boolean active;

	AbstractModule(String name, boolean active) {
		this.name = name;
		this.active = active;

		if(this.active){
			System.out.println(TalosUtil.PREFIX_LOG + "Le module " + this.name + " est activer !");
			Bukkit.getPluginManager().registerEvents(this, Talos.getInstance());
			this.onEnable();
		}else
			System.out.println(TalosUtil.PREFIX_LOG + "Le module " + this.name + " n'est pas activer !");
	}

	public boolean isActive() {
		return this.active;
	}

	public String getName() {
		return this.name;
	}

	public abstract void onEnable();

	public abstract void onDisable();

}
