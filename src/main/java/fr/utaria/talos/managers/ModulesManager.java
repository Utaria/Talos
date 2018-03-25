package fr.utaria.talos.managers;

import fr.utaria.talos.Talos;
import fr.utaria.talos.modules.AbstractModule;
import fr.utaria.talos.modules.AutoClick;
import fr.utaria.talos.modules.CPS;
import fr.utaria.talos.modules.FastBreak;
import fr.utaria.utariacore.AbstractManager;

import java.util.ArrayList;

public class ModulesManager extends AbstractManager {

    private ArrayList<AbstractModule> modules;

    public ModulesManager(){
        super(Talos.getInstance());

        modules = new ArrayList<>();

        this.addModule(new AutoClick(false));
        this.addModule(new CPS(false));
        this.addModule(new FastBreak(false));
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

}
