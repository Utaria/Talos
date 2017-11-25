package fr.utaria.talos.modules;

public class CPS extends AbstractModule {

	public CPS(boolean active) {
		super("CPS", active);
	}

	public void initialize() {
		System.out.println("active? " + this.isActive());
	}

}
