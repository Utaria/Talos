package fr.utaria.talos.menus;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.items.SkullItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ModoTeleportationMenu extends Menu {

    public ModoTeleportationMenu(Player player){
        super("Téléportation aux joueurs", MenuSize.SIX_LINE);
        this.prepare(player);
    }

    private void prepare(Player viewer){
        int i = 0;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getName().equals(viewer.getName())) continue;
            //COULEUR DU NOM EN FONCTION DE LA VIOLATION
            SkullItem head = new SkullItem(ChatColor.RED + player.getName(), player.getName());
            this.setItem(i, head);
            i++;
        }
    }

}
