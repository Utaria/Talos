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

        settings.put("reports",  String.valueOf(result.getBoolean("reports")));
        settings.put("sound_reports",  String.valueOf(result.getBoolean("sound_reports")));
        //#HELP - result.get?
        settings.put("speed_fly",  String.valueOf(result.getFloat("speed_fly")));

        return settings;
    }

}
