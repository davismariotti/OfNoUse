package use.less.commands;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import use.less.Useless;

public class LogCommand implements CommandExecutor {
	
	Useless plugin;
	
	public LogCommand(Useless u) {
		this.plugin = u;
	}

	@SuppressWarnings("resource")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		//Ok, time to get the logs
		InputStream fis = null;
		try {
			fis = new FileInputStream(plugin.getDataFolder().getPath()+"/../../server.log");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
		try {
			while(br.readLine()!=null) {
				cs.sendMessage(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

}
