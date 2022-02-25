package com.tistory.ksnd0297.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandFeed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;

		if (player.isOp()) {
			if (args.length != 1)
				return false;

			int FoodLevel = Integer.parseInt(args[0]);
			if (FoodLevel >= 0 && FoodLevel <= 10) {
				player.setFoodLevel(FoodLevel * 2);
				player.sendMessage(ChatColor.BLUE + "플레이어의 배고픔이 " + FoodLevel + "로 설정되었습니다.");
			} else
				return false;
		} else {
			player.sendMessage(ChatColor.BLUE + "플레이어는 권한이 없습니다!");
		}

		return true;
	}

}
