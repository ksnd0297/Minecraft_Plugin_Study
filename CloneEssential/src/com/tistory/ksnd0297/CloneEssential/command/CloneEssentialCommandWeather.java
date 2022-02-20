package com.tistory.ksnd0297.CloneEssential.command;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CloneEssentialCommandWeather implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		World world = player.getWorld();

		if (player.isOp()) {
			if (args.length == 0)
				return false;

			switch (args[0]) {
			case "맑음": {
				world.setClearWeatherDuration(6000);
				console.sendMessage(ChatColor.BLUE + "날씨가 맑음으로 설정되었습니다.");
				player.sendMessage(ChatColor.BLUE + "날씨가 맑음으로 설정되었습니다.");
				break;
			}
			case "비": {
				world.setStorm(true);
				console.sendMessage(ChatColor.BLUE + "날씨가 비로 설정되었습니다.");
				player.sendMessage(ChatColor.BLUE + "날씨가 비로 설정되었습니다.");
				break;
			}
			case "천둥": {
				world.setThundering(true);
				console.sendMessage(ChatColor.BLUE + "날씨가 천둥으로 설정되었습니다.");
				player.sendMessage(ChatColor.BLUE + "날씨가 천둥으로 설정되었습니다.");
				break;
			}
			}
		} else {
			player.sendMessage("명령어를 사용 할 권한이 없습니다!");
		}
		return true; // 실행
	}

}
