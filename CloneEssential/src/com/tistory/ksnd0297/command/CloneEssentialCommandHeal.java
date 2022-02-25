package com.tistory.ksnd0297.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandHeal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;

		if (player.isOp()) {
			if (args.length != 1)
				return false;

			double Health = Double.parseDouble(args[0]);
			if (Health >= 0 && Health <= 20) {
				player.setHealth(Health);
				player.sendMessage(ChatColor.BLUE + "플레이어의 체력이 " + Health + "로 설정되었습니다.");
			} else
				return false;

		} else {
			player.sendMessage(ChatColor.BLUE + "플레이어는 권한이 없습니다!");
		}

		return true;
	}

}
