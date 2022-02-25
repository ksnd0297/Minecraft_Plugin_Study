package com.tistory.ksnd0297.main;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.tistory.ksnd0297.command.CloneEssentialCommandDifficult;
import com.tistory.ksnd0297.command.CloneEssentialCommandFeed;
import com.tistory.ksnd0297.command.CloneEssentialCommandGameMode;
import com.tistory.ksnd0297.command.CloneEssentialCommandHeal;
import com.tistory.ksnd0297.command.CloneEssentialCommandHome;
import com.tistory.ksnd0297.command.CloneEssentialCommandSpawn;
import com.tistory.ksnd0297.command.CloneEssentialCommandSuicide;
import com.tistory.ksnd0297.command.CloneEssentialCommandTeleport;
import com.tistory.ksnd0297.command.CloneEssentialCommandTime;
import com.tistory.ksnd0297.command.CloneEssentialCommandWeather;
import com.tistory.ksnd0297.event.EventPlayerJoin;

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
		getCommand("홈").setExecutor(new CloneEssentialCommandHome(this));
		getCommand("스폰").setExecutor(new CloneEssentialCommandSpawn());
		getCommand("게임모드").setExecutor(new CloneEssentialCommandGameMode());
		getCommand("텔레포트").setExecutor(new CloneEssentialCommandTeleport());
		getCommand("난이도").setExecutor(new CloneEssentialCommandDifficult());
		getCommand("배고픔").setExecutor(new CloneEssentialCommandFeed());
		getCommand("체력").setExecutor(new CloneEssentialCommandHeal());
		getCommand("자살").setExecutor(new CloneEssentialCommandSuicide());
	}
}
