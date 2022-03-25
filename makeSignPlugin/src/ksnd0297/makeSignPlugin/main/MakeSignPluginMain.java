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
	private Connection con;
	public ApiSign apiSign;
	public ApiUser apiUser;

	HashMap<String, MySign> signMap;
	HashMap<String, Integer> userMap;

	public MakeSignPluginMain() {
		this.con = DBConnection.connection();
		this.apiSign = new ApiSign(this.con);
		this.apiUser = new ApiUser(this.con);

		this.signMap = apiSign.selectSign();
		this.userMap = apiUser.selectUser();
	}

	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.BLUE + "[makeSignPlugin 활성화 중 입니다]");

		getCommand("sign").setExecutor(new MakeSpecialSign(apiSign));
		pluginManager.registerEvents(new ListenerClickEvent(signMap, userMap), this);
		pluginManager.registerEvents(new ListenerJoinEvent(apiUser, userMap), this);
	}

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.RED + "[makeSignPlugin 비활성화 중 입니다]");

	}
}
