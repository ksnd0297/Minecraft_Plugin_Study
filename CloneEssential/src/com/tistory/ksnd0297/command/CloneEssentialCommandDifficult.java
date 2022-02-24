package com.tistory.ksnd0297.command;

import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandDifficult implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();

		if (player.isOp()) {
			if (args.length != 1)
				return false;

			switch (args[0]) {
			case "평화로움": {
				world.setDifficulty(Difficulty.PEACEFUL);
				break;
			}
			case "쉬움": {
				world.setDifficulty(Difficulty.EASY);
				break;
			}
			case "보통": {
				world.setDifficulty(Difficulty.NORMAL);
				break;
			}
			case "어려움": {
				world.setDifficulty(Difficulty.HARD);
				break;
			}
			default: {
				return false;
			}
			}
			player.sendMessage(ChatColor.BLUE + "난이도가 " + args[0] + "으로 설정되었습니다.");

		} else {
			player.sendMessage(ChatColor.BLUE + "플레이어는 권한이 없습니다!");
		}

		return true;
	}

}
