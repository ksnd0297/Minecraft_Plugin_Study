package com.tistory.ksnd0297.CloneEssential;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.tistory.ksnd0297.CloneEssential.command.CloneEssentialCommandSpawn;
import com.tistory.ksnd0297.CloneEssential.command.CloneEssentialCommandTime;
import com.tistory.ksnd0297.CloneEssential.command.CloneEssentialCommandWeather;
import com.tistory.ksnd0297.CloneEssential.event.EventPlayerJoin;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialMain extends JavaPlugin implements Listener {

	ConsoleCommandSender console = Bukkit.getConsoleSender();

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
	}

	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");

		getServer().getPluginManager().registerEvents(new EventPlayerJoin(), this);

		getCommand("날씨").setExecutor(new CloneEssentialCommandWeather());
		getCommand("시간").setExecutor(new CloneEssentialCommandTime());
		getCommand("스폰").setExecutor(new CloneEssentialCommandSpawn());
	}
}
