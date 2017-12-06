package fr.utaria.talos.util;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ModoUtil {

    public static final String COMPASS_NAME = ChatColor.GOLD + "Téléportation aux joueurs";
    public static final String BOOK_NAME    = ChatColor.GOLD + "Reports des joueurs";
    public static final String PAPER_NAME   = ChatColor.GOLD + "Infos des joueurs";


    private ModoUtil() {

    }


    public static void prepareForModo(Player player) {
        //Sauvegarder l'inventaire du joueur [API]
        player.getInventory().clear();
        player.setGameMode(GameMode.SPECTATOR);
        //p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        //Mettre le joueur en vanish [API]

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemStack book    = new ItemStack(Material.BOOK);
        ItemStack paper   = new ItemStack(Material.PAPER);

        ItemMeta compassMeta = compass.getItemMeta();
        ItemMeta bookMeta    = book.getItemMeta();
        ItemMeta paperMeta   = paper.getItemMeta();


        compassMeta.setDisplayName(COMPASS_NAME);
        bookMeta.setDisplayName(BOOK_NAME);
        paperMeta.setDisplayName(PAPER_NAME);

        compass.setItemMeta(compassMeta);
        book.setItemMeta(bookMeta);
        paper.setItemMeta(paperMeta);

        player.getInventory().setItem(3, compass);
        player.getInventory().setItem(4, book);
        player.getInventory().setItem(5, paper);
    }

    public static void prepareForPlayer(Player player) {
        player.getInventory().clear();
        player.setGameMode(GameMode.CREATIVE);
        //Récuperer l'inventaire du joueur [API]
        //Remettre le joueur dans le GameMode dans lequel il ?tait [API]
    }

    //Faire le systeme de pagination
    public static Inventory createInventoryMenu(String name, int size) {
        return Bukkit.createInventory(null, size, name);
    }

    public static void openInventoryMenu(Inventory inv, Player player) {
        player.openInventory(inv);
    }

    public static void fillInventoryMenuOfPlayers(Inventory inv) {

        int i = 0;
        for(Player player : Bukkit.getOnlinePlayers()) {
            ItemStack headPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
            SkullMeta headPlayerMeta = (SkullMeta) headPlayer.getItemMeta();
            headPlayerMeta.setOwner(player.getName());
            //COULEUR DU NOM EN FONCTION DE LA VIOLATION
            headPlayerMeta.setDisplayName(ChatColor.RED + player.getName());
            headPlayer.setItemMeta(headPlayerMeta);
            inv.setItem(i, headPlayer);
            i++;
        }

    }

    public static void fillInventoryMenuInfos(Inventory inv) {
        ItemStack paper = new ItemStack(Material.PAPER);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
    }

}
