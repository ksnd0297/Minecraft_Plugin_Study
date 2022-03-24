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
import ksnd0297.makeSignPlugin.db.ApiUser;
import ksnd0297.makeSignPlugin.db.DBConnection;
import ksnd0297.makeSignPlugin.event.ListenerClickEvent;
import ksnd0297.makeSignPlugin.event.ListenerJoinEvent;

public class MakeSignPluginMain extends JavaPlugin implements Listener {
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	PluginManager pluginManager = Bukkit.getServer().getPluginManager();
	private Connection con = null;

	@Override
	public void onEnable() {
		con = DBConnection.connection();
		ApiSign apiSign = new ApiSign(con);
		ApiUser apiUser = new ApiUser(con);
		HashMap<String, MySign> signMap = apiSign.selectSign();
		HashMap<String, Integer> userMap = apiUser.selectUser();
		console.sendMessage(ChatColor.BLUE + "[makeSignPlugin 활성화 중 입니다]");

		getCommand("sign").setExecutor(new MakeSpecialSign(apiSign));
		pluginManager.registerEvents(new ListenerClickEvent(signMap), this);
		pluginManager.registerEvents(new ListenerJoinEvent(apiUser, userMap), this);
	}

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.RED + "[makeSignPlugin 비활성화 중 입니다]");
	}
}
