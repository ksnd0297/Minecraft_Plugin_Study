package com.tistory.ksnd0297.CloneEssential.command;

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
			if (args.length != 2)
				return false;

			if (args[0].equals("설정")) {
				int time = Integer.parseInt(args[1]);
				world.setTime(time);
			} else
				return false;
		}

		return true;
	}

}
