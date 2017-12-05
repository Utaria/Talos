package fr.utaria.talos.modules;

import fr.utaria.talos.Talos;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class AbstractModule implements Listener {

	private String name;
	private boolean active;

	AbstractModule(String name, boolean active) {
		this.name = name;
		this.active = active;

		Bukkit.getPluginManager().registerEvents(this, Talos.getInstance());

		this.initialize();
	}

	public boolean isActive() {
		return this.active;
	}

	public String getName() {
		return this.name;
	}

	public abstract void initialize();

}
