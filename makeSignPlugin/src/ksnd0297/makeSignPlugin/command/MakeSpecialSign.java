package ksnd0297.makeSignPlugin.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ksnd0297.makeSignPlugin.db.ApiSign;
import ksnd0297.makeSignPlugin.main.MySign;

public class MakeSpecialSign implements CommandExecutor {
	ApiSign apiSign;

	public MakeSpecialSign(ApiSign api) {
		this.apiSign = api;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

		Player player = (Player) sender;
		if (args.length != 4)
			return false;

		if (player.isOp()) {
			try {
				Block block = player.getTargetBlock(null, 10);
				block.setType(Material.OAK_SIGN);

				Sign sign = (Sign) block.getState();
				sign.setLine(0, args[0]);
				sign.setLine(1, ChatColor.WHITE + args[1]);
				sign.setLine(2, ChatColor.WHITE + args[2]);
				// sign.getBlockData();
				sign.update();

				String item = args[0];
				Integer buy = Integer.parseInt(args[1]);
				Integer sell = Integer.parseInt(args[2]);
				String matchItem = "minecraft:" + args[3];
				MySign mySign = new MySign(sign, item, buy, sell, matchItem);

				apiSign.insertSign(mySign);

			} catch (Exception error) {
				error.printStackTrace();
			}
		}

		return true;
	}
}
