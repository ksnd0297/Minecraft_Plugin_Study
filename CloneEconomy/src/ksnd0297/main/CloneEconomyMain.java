package ksnd0297.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import ksnd0297.command.CloneEconomyMoney;
import ksnd0297.event.PlayerJoin;

public class CloneEconomyMain extends JavaPlugin implements Listener {

	ConsoleCommandSender console = Bukkit.getConsoleSender();

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.AQUA + "[CloneEconomy] 활성화 중");
	}

	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.AQUA + "[CloneEconomy] 비활성화 중");

		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		getCommand("돈").setExecutor(new CloneEconomyMoney(this));
	}
}
