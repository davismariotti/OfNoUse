package use.less;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import use.less.commands.LogCommand;
import use.less.listener.UselessListening;

public class Useless extends JavaPlugin {
	public boolean getChance(int chance) {
		return this.rnd.nextInt() < chance;
	}
	Random rnd = new Random();
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new UselessListening(this), this);
		this.getCommand("log").setExecutor(new LogCommand(this));
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for(Player p:Bukkit.getOnlinePlayers()) {
					p.sendMessage(ChatColor.GREEN+"I AM ENABLED!");
					Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"I AM ENABLED!");
				}
			}
		}, 0L, 400L);
	}
	
	

}
