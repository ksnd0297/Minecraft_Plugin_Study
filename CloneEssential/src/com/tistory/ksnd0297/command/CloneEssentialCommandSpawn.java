package com.tistory.ksnd0297.CloneEssential.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CloneEssentialCommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;

		if (player.isOp()) { // /스폰 [지정, 이동]
			if (args.length == 0)
				return false;

			switch (args[0]) {
			case "지정": {
				player.
			}
			case "이동": {

			}
			default: {

			}
			}

			return true;
		}

		return false;
	}

}
