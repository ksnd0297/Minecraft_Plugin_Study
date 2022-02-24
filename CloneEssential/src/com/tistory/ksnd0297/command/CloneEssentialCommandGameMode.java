package com.tistory.ksnd0297.command;

import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandGameMode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();

		if (player.isOp()) {
			switch (args[0]) {
			case "크리에이티브": {
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.BLUE + "크레이이티브 모드로 설정되었습니다.");
				break;
			}
			case "서바이벌": {
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.BLUE + "서바이벌 모드로 설정되었습니다.");
				break;
			}
			default: {
				return false;
			}
			}
		} else {
			player.sendMessage(ChatColor.BLUE + "플레이어는 권한이 없습니다!");
		}

		return true;
	}

}
