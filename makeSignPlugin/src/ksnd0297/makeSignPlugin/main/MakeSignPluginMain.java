package ksnd0297.makeSignPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ksnd0297.makeSignPlugin.command.MakeSpecialSign;

public class MakeSignPluginMain extends JavaPlugin implements Listener {
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	PluginManager pluginManager = Bukkit.getServer().getPluginManager();

	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.BLUE + "[makeSignPlugin 활성화 중 입니다]");
		pluginManager.registerEvents(this, this);

		getCommand("sign").setExecutor(new MakeSpecialSign());
	}

	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.RED + "[makeSignPlugin 비활성화 중 입니다]");
	}

	@EventHandler
	public void blockSet(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		player.sendMessage(Integer.toString(event.getItemInHand().getItemMeta().getCustomModelData()));
		player.sendMessage("블록설치완료!");
	}
}
