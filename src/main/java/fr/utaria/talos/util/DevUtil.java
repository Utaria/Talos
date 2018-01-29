package fr.utaria.talos.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DevUtil {

    public static final String CHEST_NAME   = ChatColor.GOLD + "Paramètres des modules de l'anti-cheat";
    public static final String NAMETAG_NAME = ChatColor.DARK_GRAY + "Paramètres du mode Dev";

    public static final ArrayList<String> CHEST_LORE   = new ArrayList<>();
    public static final ArrayList<String> NAMETAG_LORE = new ArrayList<>();

    public static final String PREFIX_DEBUG = ChatColor.BOLD + "" + ChatColor.RED + "[DEBUG] " + ChatColor.WHITE;

    private DevUtil(){

    }

    public static void prepareForDev(Player player){
        ItemStack chest   = new ItemStack(Material.CHEST);
        ItemStack nameTag = new ItemStack(Material.NAME_TAG);

        ItemMeta chestMeta   = chest.getItemMeta();
        ItemMeta nameTagMeta = nameTag.getItemMeta();

        chestMeta.setDisplayName(CHEST_NAME);
        nameTagMeta.setDisplayName(NAMETAG_NAME);

        //CHEST
        CHEST_LORE.add("Permet de gérer tout les paramètres");
        CHEST_LORE.add("des modules de l'anti-cheat !");
        //NAME TAG
        NAMETAG_LORE.add("Permet de gérer tout les paramètres du mode Dev !");

        chestMeta.setLore(CHEST_LORE);
        nameTagMeta.setLore(NAMETAG_LORE);

        chest.setItemMeta(chestMeta);
        nameTag.setItemMeta(nameTagMeta);

        player.getInventory().setItem(7, chest);
        player.getInventory().setItem(8, nameTag);

    }

    public static void sendDebug(String debug){
        Bukkit.broadcastMessage(PREFIX_DEBUG + debug);
    }

}
