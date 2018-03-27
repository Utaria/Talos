package fr.utaria.talos.util;

import fr.utaria.utariacore.players.PlayerInfo;
import fr.utaria.utariadatabase.database.Database;
import fr.utaria.utariadatabase.database.DatabaseManager;
import fr.utaria.utariadatabase.query.SelectQuery;
import fr.utaria.utariadatabase.result.DatabaseSet;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class SettingsUtil {

    private static Database db;

    private SettingsUtil(){

    }

    static{
        db = DatabaseManager.getDB("talos");
    }

    public static HashMap<String, String> getPlayerSettings(Player player){
        HashMap<String, String> settings = new HashMap<>();

        SelectQuery selectQuery = db.select();
        selectQuery.from("settings");
        selectQuery.where("player_id = ?");
        selectQuery.attributes(PlayerInfo.get(player).getId());
        DatabaseSet result = selectQuery.find();

        if(result != null){
            settings.put("reports",  String.valueOf(result.getString("reports")));
            settings.put("sound_reports",  String.valueOf(result.getString("sound_reports")));
            settings.put("speed_fly",  String.valueOf(result.getFloat("speed_fly")));
        }else{
            settings.put("reports", String.valueOf(true));
            settings.put("sound_reports", String.valueOf(false));
            settings.put("speed_fly", String.valueOf(true));
        }

        return settings;
    }
    
    public static void savePlayerSettings(Player player, HashMap<String, String> settings) {
    	db.update("settings").fields(settings.keySet().toArray(new String[0])).values(settings.values().toArray(new String[0])).where("player_id = ?").attributes(PlayerInfo.get(player).getId()).execute();
    }

}
