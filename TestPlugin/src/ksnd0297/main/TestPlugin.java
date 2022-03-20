package ksnd0297.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {
	PluginManager pluginManager = getServer().getPluginManager();
	ConsoleCommandSender console = Bukkit.getConsoleSender();

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.RED + "[TestPlugin이 비활성화 중입니다.]");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		console.sendMessage(ChatColor.BLUE + "[TestPlugin이 활성화 중입니다.]");
		pluginManager.registerEvents(this, this);
	}

}
