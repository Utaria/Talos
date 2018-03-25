package fr.utaria.talos.util;

import java.util.HashMap;

import fr.utaria.utariadatabase.database.Database;
import fr.utaria.utariadatabase.database.DatabaseManager;
import fr.utaria.utariadatabase.query.SelectQuery;

public class ModulesUtils {

	private static Database db;
	
	private ModulesUtils(){
		
	}
	
	static{
		db = DatabaseManager.getDB("talos");
	}
	
	public static HashMap<String, String> getModulesState(){
		HashMap<String, String> stateModules = new HashMap<>();
		
        SelectQuery selectQuery = db.select();
        selectQuery.from("modules");
		
		return stateModules;
	}
	
}
