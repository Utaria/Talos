package fr.utaria.talos.commands;

import fr.utaria.talos.Talos;
import fr.utaria.talos.util.ModoUtil;
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

        Player player = (Player) sender;

        String state;

        if(args.length == 0) {
            boolean modo = Talos.getPlayerInfos(player).isModo();
            if(modo){
                state = "off";
            }else{
                state = "on";
            }
        }else {
            state = args[0];
        }

        switch (state) {
            case "on":

                if (!Talos.getModPlayers().contains(player.getUniqueId())) {
                    Talos.getModPlayers().add(player.getUniqueId());
                    Talos.getPlayerInfos(player).setModo(true);
                    ModoUtil.prepareForModo(player);
                    //sender.sendMessage(ChatColor.GOLD + "Vous venez de rejoindre le mode Modération !");
                } else {
                    sender.sendMessage(ChatColor.RED + "Vous êtes déjà dans le mode Modération !");
                }

                break;
            case "off":

                if (Talos.getModPlayers().contains(player.getUniqueId())) {
                    Talos.getModPlayers().remove(player.getUniqueId());
                    Talos.getPlayerInfos(player).setModo(false);
                    ModoUtil.prepareForPlayer(player);
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
