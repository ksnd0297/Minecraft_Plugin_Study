package com.tistory.ksnd0297.command;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CloneEssentialCommandTime implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();

		if (player.isOp()) {
			if (args.length != 1)
				return false;

			switch (args[0]) {
			case "아침": {
				world.setTime(0);
				player.sendMessage("");
				break;
			}
			case "점심": {
				world.setTime(6000);
				break;
			}
			case "저녁": {
				world.setTime(12000);
				break;
			}
			case "새벽": {
				world.setTime(20000);
				break;
			}
			default: {
				return false;
			}
			}
			player.sendMessage(ChatColor.BLUE + "시간이 [" + args[0] + "] 으로 설정 되었습니다.");
		} else {
			player.sendMessage(ChatColor.BLUE + "플레이어는 권한이 없습니다!");
		}

		return true;
	}

}
