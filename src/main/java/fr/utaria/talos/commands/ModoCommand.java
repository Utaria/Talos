package fr.utaria.talos.commands;

import fr.utaria.talos.Talos;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Vous n'êtes pas un joueur !");
            return true;
        }

        Player p = (Player) sender;

        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Utilisation : /m <on/off>");
            return true;
        }

        String state = args[0];

        switch (state) {
            case "on":

                if (!Talos.getModPlayers().contains(p.getUniqueId())) {
                    Talos.getModPlayers().add(p.getUniqueId());
                    //ModoUtils.prepareForModo(p);
                    //sender.sendMessage(ChatColor.GOLD + "Vous venez de rejoindre le mode Modération !");
                } else {
                    sender.sendMessage(ChatColor.RED + "Vous êtes déjà dans le mode Modération !");
                }

                break;
            case "off":

                if (Talos.getModPlayers().contains(p.getUniqueId())) {
                    Talos.getModPlayers().remove(p.getUniqueId());
                    //ModoUtils.prepareForPlayer(p);
                    //sender.sendMessage(ChatColor.GOLD + "Vous venez de quitter le mode Modération !");
                } else {
                    sender.sendMessage(ChatColor.RED + "Vous n'êtes pas dans le mode Modération !");
                }

                break;
            default:
                return true;
        }

        return true;
    }

}
