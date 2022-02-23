package com.tistory.ksnd0297.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.tistory.ksnd0297.command.CloneEssentialCommandSpawn;
import com.tistory.ksnd0297.command.CloneEssentialCommandTime;
import com.tistory.ksnd0297.command.CloneEssentialCommandWeather;
import com.tistory.ksnd0297.event.EventPlayerJoin;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialMain extends JavaPlugin implements Listener {

	ConsoleCommandSender console = Bukkit.getConsoleSender();

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
		saveConfig();
	}

	@Override
	public void onEnable() {

		saveConfig();
		File cfile = new File(getDataFolder(), "config.yml");
		if (cfile.length() == 0) {
			getConfig().options().copyDefaults(true); // 이클립스에서 작성한 내용 저장
			saveConfig();
		}
		console.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");

		getServer().getPluginManager().registerEvents(new EventPlayerJoin(), this);

		getCommand("날씨").setExecutor(new CloneEssentialCommandWeather());
		getCommand("시간").setExecutor(new CloneEssentialCommandTime());
		getCommand("홈").setExecutor(new CloneEssentialCommandSpawn(this));
	}
}
