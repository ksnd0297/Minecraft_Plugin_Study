package com.tistory.ksnd0297.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandSuicide implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;

		if (player.isOp()) {
			player.setHealth(0);
		} else {
			player.sendMessage(ChatColor.BLUE + "플레이어는 권한이 없습니다!");
		}

		return true;
	}

}
