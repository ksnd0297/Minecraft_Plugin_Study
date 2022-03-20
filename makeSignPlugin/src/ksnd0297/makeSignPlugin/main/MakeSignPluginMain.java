package ksnd0297.makeSignPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ksnd0297.makeSignPlugin.event.MakeSign;

public class MakeSignPluginMain extends JavaPlugin implements Listener {
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	PluginManager pluginManager = Bukkit.getServer().getPluginManager();

	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.BLUE + "[makeSingPlugin 활성화 중 입니다]");
		pluginManager.registerEvents(new MakeSign(), this);
	}

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.RED + "[makeSingPlugin 비활성화 중 입니다]");
	}

}
