package fr.utaria.talos.managers;

import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.AbstractModule;
import fr.utaria.talos.modules.AutoClick;
import fr.utaria.talos.modules.CPS;
import fr.utaria.talos.modules.FastBreak;
import fr.utaria.utariacore.AbstractManager;
import fr.utaria.utariadatabase.database.DatabaseManager;
import fr.utaria.utariadatabase.result.DatabaseSet;

import java.util.ArrayList;
import java.util.List;

public class ModulesManager extends AbstractManager {

    private ArrayList<AbstractModule> modules;

    public ModulesManager(){
        super(Talos.getInstance(), "talos");

        modules = new ArrayList<>();

        this.addModule(new AutoClick(false));
        this.addModule(new CPS(false));
        this.addModule(new FastBreak(false));
        this.loadsModulesState();
    }

    @Override
    public void initialize() {

    }

    public ArrayList<AbstractModule> getModules(){
        return modules;
    }

    private void addModule(AbstractModule module){
        if(!modules.contains(module))
            modules.add(module);
    }
    
    public AbstractModule getModule(String name) {
    	for(AbstractModule module : this.getModules()) {
    		if(module.getName().equals(name))
    			return module;
    	}
		return null;
    }
    
    private void loadsModulesState() {
    	List<DatabaseSet> result = getDB().select().from("modules").findAll();
    	for(DatabaseSet res : result) {
    		AbstractModule module = this.getModule(res.getString("name"));
    		if(module != null)
    			module.setActive(res.getInteger("state") == 1);
    	}
    }
    
    public void saveModulesState() {
    	for(AbstractModule module : this.getModules()) {
    		getDB().update("modules").fields("state").values(module.isActive()).where("name = ?").attributes(module.getName()).execute();
    	}
    }

}
