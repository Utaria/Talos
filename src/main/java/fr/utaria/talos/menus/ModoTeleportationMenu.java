package fr.utaria.talos.menus;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.event.ItemClickEvent;
import fr.utaria.utariacore.menus.event.ItemClickListener;
import fr.utaria.utariacore.menus.items.SkullItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ModoTeleportationMenu extends Menu {

    public ModoTeleportationMenu(Player player){
        super("Téléportation aux joueurs", MenuSize.SIX_LINE);
        this.preparer(player);
    }

    private void preparer(Player viewer){
        int i = 0;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getName().equals(viewer.getName())) continue;
            if(player.getWorld().getName().equals("event")) continue;
            //COULEUR DU NOM EN FONCTION DE LA VIOLATION
            SkullItem head = new SkullItem(player.getName(), player.getName());
            head.onItemClick(itemClickEvent -> {
            	if(!player.getWorld().getName().equals("event"))
            		itemClickEvent.getPlayer().teleport(player);
            });
            this.setItem(i, head);
            i++;
        }
    }

}
