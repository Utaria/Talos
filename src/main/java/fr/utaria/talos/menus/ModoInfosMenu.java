package fr.utaria.talos.menus;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.event.ItemClickEvent;
import fr.utaria.utariacore.menus.event.ItemClickListener;
import fr.utaria.utariacore.menus.helper.DescriptionBuilder;
import fr.utaria.utariacore.menus.items.SkullItem;
import fr.utaria.utariacore.util.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ModoInfosMenu extends Menu {

    private static DescriptionBuilder db;
    private static ArrayList<String> plugList;

    public ModoInfosMenu(Player player){
        super("Infos des joueurs", MenuSize.SIX_LINE);
        plugList = new ArrayList<>();
        this.preparer(player);
    }

    private void preparer(Player viewer) {
        int i = 0;
        for(Player player : Bukkit.getOnlinePlayers()){
            db = new DescriptionBuilder();
            //if(player.getName().equals(viewer.getName())) continue;
            //COULEUR DU NOM EN FONCTION DE LA VIOLATION
            db.append(ChatColor.GOLD + "Infos du joueur :");
            db.append(ChatColor.WHITE + "Cliques par seconde = ");
            db.append(ChatColor.WHITE + "Ping                = " + PlayerUtil.getPing(player) + "/ms");
            db.append(ChatColor.WHITE + "Violation           = 15");
            SkullItem head = new SkullItem(ChatColor.RED + player.getName(), player.getName(), db.toArray());

            plugList.add(ChatColor.GOLD + "Infos du joueur " + player.getName() + ": ");
            plugList.add("");
            //COULEUR DU RESULTAT EN FONCTION DE L'IMPORTANCE DU CHIFFRE
            //- que 8 = vert - que 13 orange + que 13 rouge
            plugList.add("Clique        = " + ChatColor.BOLD + "7" + ChatColor.RESET + "/s");
            plugList.add("Top clique = " + ChatColor.BOLD + "9" + ChatColor.RESET + "/s");
            //- 80 = vert - que 200 = orange + que 200 = rouge
            plugList.add("Ping           = " + ChatColor.BOLD + PlayerUtil.getPing(player) + ChatColor.RESET + "/ms");
            plugList.add("Violation    = " + ChatColor.BOLD + "15");

            for(String message : plugList){
                head.onItemClick(itemClickEvent -> itemClickEvent.getPlayer().sendMessage(message));
            }
            this.setItem(i, head);
            i++;
        }
    }

}
