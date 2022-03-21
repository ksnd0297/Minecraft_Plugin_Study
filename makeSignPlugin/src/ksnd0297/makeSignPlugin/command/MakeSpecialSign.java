package ksnd0297.makeSignPlugin.command;

import java.sql.Connection;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ksnd0297.makeSignPlugin.db.ApiSign;

public class MakeSpecialSign implements CommandExecutor {
	Connection con = null;
	ApiSign api;

	public MakeSpecialSign(Connection con) {
		this.con = con;
		api = new ApiSign(con);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

		Player player = (Player) sender;
		if (args.length != 3)
			return false;

		if (player.isOp()) {
			try {
				Block block = player.getTargetBlock(null, 10);
				block.setType(Material.OAK_SIGN);

				Sign sign = (Sign) block.getState();
				sign.setLine(0, ChatColor.WHITE + "<" + args[0] + ">");
				sign.setLine(1, ChatColor.WHITE + "<" + args[1] + ">");
				sign.setLine(2, ChatColor.WHITE + "<" + args[2] + ">");
				sign.update();

				String position = "111";
				String item = args[0];
				Integer buy = Integer.parseInt(args[1]);
				Integer sell = Integer.parseInt(args[2]);
				String matchItem = "AAA";

				api.insertSign(position, item, buy, sell, matchItem);

			} catch (Exception error) {
				error.printStackTrace();
			}
		}

		return true;
	}

}
