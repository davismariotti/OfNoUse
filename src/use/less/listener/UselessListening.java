package use.less.listener;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

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
	
}

