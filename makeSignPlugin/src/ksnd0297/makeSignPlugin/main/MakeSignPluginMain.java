package ksnd0297.makeSignPlugin.main;

import java.sql.Connection;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ksnd0297.makeSignPlugin.command.MakeSpecialSign;
import ksnd0297.makeSignPlugin.db.ApiSign;
import ksnd0297.makeSignPlugin.db.DBConnection;
import ksnd0297.makeSignPlugin.event.ListenerClickEvent;

public class MakeSignPluginMain extends JavaPlugin implements Listener {
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	PluginManager pluginManager = Bukkit.getServer().getPluginManager();
	private Connection con = null;

	@Override
	public void onEnable() {
		con = DBConnection.connection();
		ApiSign api = new ApiSign(con);
		HashMap<String, MySign> map = api.selectSign();
		System.out.println(map.size());
		console.sendMessage(ChatColor.BLUE + "[makeSignPlugin 활성화 중 입니다]");

		getCommand("sign").setExecutor(new MakeSpecialSign(con));
		pluginManager.registerEvents(new ListenerClickEvent(map), this);
	}

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.RED + "[makeSignPlugin 비활성화 중 입니다]");
	}
}
