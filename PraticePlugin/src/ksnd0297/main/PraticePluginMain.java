package ksnd0297.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import ksnd0297.command.WorldEditAxe;
import ksnd0297.command.WorldEditFill;
import ksnd0297.event.WorldEdit;
import net.md_5.bungee.api.ChatColor;

public class PraticePluginMain extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		WorldEdit worldEdit = new WorldEdit();
		WorldEditFill worldEditFill = new WorldEditFill(worldEdit);
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[PraticePlugin] 활성화 중");
		getServer().getPluginManager().registerEvents(worldEdit, this);
		getCommand("도끼").setExecutor(new WorldEditAxe());
		getCommand("채우기").setExecutor(worldEditFill);
	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[PraticePlugin] 비활성화 중");
	}
}
