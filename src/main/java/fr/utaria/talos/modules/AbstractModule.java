package fr.utaria.talos.modules;

public abstract class AbstractModule {

	private String name;
	private boolean active;

	AbstractModule(String name, boolean active) {
		this.name = name;
		this.active = active;

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
