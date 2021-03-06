package com.tistory.cchplugin.cchlecture;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.tistory.cchplugin.cchlecture.command.CchCommand;
import com.tistory.cchplugin.cchlecture.event.CchEvent;
import com.tistory.cchplugin.cchlecture.file.CchFile;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

	public ConsoleCommandSender console = Bukkit.getConsoleSender();

	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");

		CchEvent.setPlugin(this);
		CchFile.setPlugin(this);

		CchEvent cchEvent = new CchEvent();
		CchFile cchFile = new CchFile();

		getCommand("test").setExecutor(new CchCommand());

		getServer().getPluginManager().registerEvents(cchEvent, this);
		cchFile.makeFile(cchFile.f);
		cchFile.mapToFile(cchFile.f, cchEvent.map);
		cchFile.fileToMap(cchFile.f, cchEvent.map);
	}

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
	}

}
