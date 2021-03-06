package com.tistory.cchplugin.cchlecture.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CchCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

		Player player = (Player) sender;

		if (player.isOp()) {

			if (args.length == 0)
				return false; // false가 return 되면 plugin.yml에 작성된 usage 부분이 출력됩니다.

			switch (args[0]) {

			case "공지": {
				player.sendMessage("/test 공지     를 입력했습니다");
				break;
			}
			case "op": {
				player.sendMessage("/test op     를 입력했습니다");
				break;
			}
			case "초기화": {
				player.sendMessage("/test 초기화     를 입력했습니다");
				break;
			}
			default: {
				player.sendMessage("등록되지 않은 명령어를 입력했습니다");
				break;
			}
			}

		} else {

			player.sendMessage("명령어를 사용 할 권한이 없습니다!");

		}

		return true;
	}

}
