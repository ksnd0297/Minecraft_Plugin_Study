package com.tistory.ksnd0297.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CloneEssentialCommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();
		Location location = player.getLocation();

		if (player.isOp()) {
			if (args.length != 1)
				return false;

			switch (args[0]) {
			case "지정": {
				world.setSpawnLocation(location);
				player.sendMessage(ChatColor.BLUE + "스폰이 설정되었습니다.");
				break;
			}
			case "이동": {
				player.teleport(world.getSpawnLocation());
				player.sendMessage(ChatColor.BLUE + "스폰으로 이동했습니다.");
				break;
			}
			default: {
				player.sendMessage(ChatColor.BLUE + "스폰 명령어는 지정, 이동 중에 사용할 수 있습니다.");
			}
			}
		}

		return true;
	}

}
