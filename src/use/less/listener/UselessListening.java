package use.less.listener;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;

import use.less.Useless;

public class UselessListening implements Listener {

	public boolean getChance(int chance) {
		return this.rnd.nextInt() < chance;
	}
	
	
	Useless plugin;
	Random rnd = new Random();
	
	public UselessListening(Useless useless) {
		this.plugin = useless;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if(getChance(1) && getChance(1) && getChance(1) && getChance(1)) {
			event.setCancelled(true);
		}
	}
	
	// Little check for vowels
	
	   public boolean beginsWithVowel(String str){
               return (str.startsWith("a") || str.startsWith("e") || str.startsWith("i") || str.startsWith("o") || str.startsWith("u"));
           }
	
	// Tell the player they have placed a block
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		event.getPlayer().sendMessage(ChatColor.GOLD + "You have successfully placed " + 
		(beginsWithVowel(event.getBlockPlaced().getType().toString()) ? "an" : "a") + 
		" " + event.getBlockPlaced().getType().toString().toLowerCase() + ".");
		
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		event.getPlayer().sendMessage(ChatColor.GOLD + "You have successfully broken " + 
		(beginsWithVowel(event.getBlock().getType().toString()) ? "an" : "a") + 
		" " + event.getBlock().getType().toString().toLowerCase() + ".");	    	
	}
	}
}

