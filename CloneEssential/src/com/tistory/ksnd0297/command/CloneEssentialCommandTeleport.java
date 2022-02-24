package com.tistory.ksnd0297.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandTeleport implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;

		if (player.isOp()) {
			if (args.length != 1)
				return false;

			Boolean flag = false;
			for (Player target : Bukkit.getOnlinePlayers()) {
				if (target.getName().equals(args[0])) {
					player.teleport(target);
					player.sendMessage(ChatColor.BLUE + target.getName() + " 님에게 순간이동 되었습니다.");
					flag = true;
					break;
				}
			}
			if (!flag) {
				player.sendMessage(ChatColor.BLUE + args[0] + " 님을 찾을 수 없습니다.");
			}
		}

		return true;
	}

}
