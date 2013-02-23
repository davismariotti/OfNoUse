package use.less.listener;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.block.BlockPlaceEvent;

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
	
	   public boolean BeginsWithVowel(String str){
               if(str.startsWith("a") || str.startsWith("e") || str.startsWith("i") || str.startsWith("o") || str.startsWith("u")){
                   return true;
               }
               return BeginsWithVowel(str);
           }
	
	// Tell the player they have placed a block
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		event.getPlayer().sendMessage(ChatColor.GOLD + "You have successfully placed " + 
		(BeginsWithVowel(event.getBlockPlaced().toString()) ? "an" : "a") + 
		" " + event.getBlockPlaced().toString().toLowerCase() + ".");
	}
}

