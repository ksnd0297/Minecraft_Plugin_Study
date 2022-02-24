package com.tistory.ksnd0297.command;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tistory.ksnd0297.main.CloneEssentialMain;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandHome implements CommandExecutor {
	public static CloneEssentialMain plugin;

	public CloneEssentialCommandHome(CloneEssentialMain cloneEssentialMain) {
		plugin = cloneEssentialMain;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();
		UUID uuid = player.getUniqueId();

		if (player.isOp()) {
			if (args.length != 1)
				return false;

			switch (args[0]) {
			case "지정": {
				Location location = player.getLocation();
				plugin.getConfig().set(uuid + ".x", Double.toString(location.getX()));
				plugin.getConfig().set(uuid + ".y", Double.toString(location.getY()));
				plugin.getConfig().set(uuid + ".z", Double.toString(location.getZ()));
				plugin.saveConfig();
				player.sendMessage(ChatColor.BLUE + "집이 설정되었습니다.");
				break;
			}

			case "이동": {
				double x = Double.parseDouble(plugin.getConfig().getString(uuid + ".x"));
				double y = Double.parseDouble(plugin.getConfig().getString(uuid + ".y"));
				double z = Double.parseDouble(plugin.getConfig().getString(uuid + ".z"));
				Location location = new Location(world, x, y, z);
				player.teleport(location);
				player.sendMessage(ChatColor.BLUE + "집으로 이동했습니다.");
				break;
			}
			default: {
				player.sendMessage(ChatColor.BLUE + "홈 명령어는 지정, 이동 중에 사용할 수 있습니다.");
			}
			}
		} else {
			player.sendMessage(ChatColor.BLUE + "플레이어는 권한이 없습니다!");
		}

		return true;
	}

}
