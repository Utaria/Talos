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

        SelectQuery selectQuery = db.select("sound_reports","request_friends");
        selectQuery.from("settings");
        selectQuery.where("player_id = ?");
        selectQuery.attributes(PlayerInfo.get(player).getId());
        DatabaseSet result = selectQuery.find();

        settings.put("sound_reports",  String.valueOf(result.getBoolean("sound_reports")));
        settings.put("request_friends", String.valueOf(result.getBoolean("request_friends")));

        return settings;
    }

}
