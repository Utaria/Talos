package fr.utaria.talos.util;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ModoUtil {

    //TOOL BAR
    public static final String COMPASS_NAME = ChatColor.GOLD + "Téléportation aux joueurs";
    public static final String BOOK_NAME    = ChatColor.GOLD + "Reports des joueurs";
    public static final String PAPER_NAME   = ChatColor.GOLD + "Infos des joueurs";
    public static final String NAMETAG_NAME = ChatColor.DARK_GRAY + "Paramètres du mode Modo";

    private static final ArrayList<String> COMPASS_LORE = new ArrayList<>();
    private static final ArrayList<String> BOOK_LORE    = new ArrayList<>();
    private static final ArrayList<String> PAPER_LORE   = new ArrayList<>();
    private static final ArrayList<String> NAMETAG_LORE = new ArrayList<>();

    //INFOS MENU
    public static final String INFOS_NAME = ChatColor.GOLD + "Information Générales";
    public static final ArrayList<String> INFOS_LORE = new ArrayList<>();

    private ModoUtil() {

    }

    static{
        //COMPASS
        COMPASS_LORE.add("Permet de se téléporter à n'importe");
        COMPASS_LORE.add("quel joueur en un clique !");
        //BOOK
        BOOK_LORE.add("Permet de prendre connaissance de");
        BOOK_LORE.add("tout les reports de chaque joueur !");
        //PAPER
        PAPER_LORE.add("Permet d'avoir toute les infos de");
        PAPER_LORE.add("chaque joueur ! (Violation, CPS...)");
        //NAME TAG
        NAMETAG_LORE.add("Permet de gérer tout les paramètres du mode Modo !");
    }

    public static void prepareForModo(Player player) {

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemStack book    = new ItemStack(Material.BOOK);
        ItemStack paper   = new ItemStack(Material.PAPER);
        ItemStack nameTag   = new ItemStack(Material.NAME_TAG);

        ItemMeta compassMeta = compass.getItemMeta();
        ItemMeta bookMeta    = book.getItemMeta();
        ItemMeta paperMeta   = paper.getItemMeta();
        ItemMeta nameTagMeta   = nameTag.getItemMeta();

        compassMeta.setDisplayName(COMPASS_NAME);
        bookMeta.setDisplayName(BOOK_NAME);
        paperMeta.setDisplayName(PAPER_NAME);
        nameTagMeta.setDisplayName(NAMETAG_NAME);

        compassMeta.setLore(COMPASS_LORE);
        bookMeta.setLore(BOOK_LORE);
        paperMeta.setLore(PAPER_LORE);
        nameTagMeta.setLore(NAMETAG_LORE);

        compass.setItemMeta(compassMeta);
        book.setItemMeta(bookMeta);
        paper.setItemMeta(paperMeta);
        nameTag.setItemMeta(nameTagMeta);

        player.getInventory().setItem(3, compass);
        player.getInventory().setItem(4, book);
        player.getInventory().setItem(5, paper);
        player.getInventory().setItem(8, nameTag);

    }


}
