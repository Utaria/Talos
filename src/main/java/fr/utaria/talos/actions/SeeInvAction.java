package fr.utaria.talos.actions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.utaria.utariacore.players.UtariaPlayer;
import fr.utaria.utariacore.players.modes.PlayerModes;

public class SeeInvAction {

    private Player player;

    public SeeInvAction(Player player){
        this.player = player;
        this.run();
    }

    private void run(){
    	Inventory inv = this.player.getInventory();
    	
    	if(UtariaPlayer.get(this.player).hasMode(PlayerModes.getDefault())) {
    		
    	}else {
    		
    	}
    }

}
