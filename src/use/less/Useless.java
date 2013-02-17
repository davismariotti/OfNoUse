package use.less;

import org.bukkit.plugin.java.JavaPlugin;

import use.less.listener.UselessListening;

public class Useless extends JavaPlugin {
	
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new UselessListening(this), this);
	}

}
