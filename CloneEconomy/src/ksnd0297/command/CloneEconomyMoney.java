package ksnd0297.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ksnd0297.db.CloneEconomyDB;
import ksnd0297.main.CloneEconomyMain;
import net.md_5.bungee.api.ChatColor;

public class CloneEconomyMoney implements CommandExecutor {
	public static CloneEconomyMain plugin;

	public CloneEconomyMoney(CloneEconomyMain CloneEconomyMain) {
		plugin = CloneEconomyMain;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		String SenderUuid = player.getUniqueId().toString();
		CloneEconomyDB db = new CloneEconomyDB();

		switch (args[0]) {
		case "확인": {
			String Money = Integer.toString(db.getMoney(SenderUuid.toString()));
			player.sendMessage(ChatColor.BLUE + "현재 " + player.getName() + "님이 가지고 있는 돈은 " + Money + "원입니다.");
			break;
		}
		case "송금": {
			if (args.length != 3)
				return false;

			int SendMoney = Integer.parseInt(args[2]); // 다른 플레이어에게 보낼 돈
			int SenderMoney = db.getMoney(SenderUuid); // Sender의 돈

			if (SenderMoney >= SendMoney) {
				for (Player Receiver : Bukkit.getOnlinePlayers()) {
					if (Receiver.getName().equals(args[1])) { // 보낼사람 체크
						String ReceiverUuid = Receiver.getUniqueId().toString();
						int ReceiverMoney = db.getMoney(ReceiverUuid);
						db.UpdateMoney(SenderUuid, SenderMoney - SendMoney);
						db.UpdateMoney(ReceiverUuid, ReceiverMoney + SendMoney);
						player.sendMessage(ChatColor.BLUE + Receiver.getName() + "님에게 " + SendMoney + "가 송금되었습니다.");
						return true;
					}
				}
			} else {
				player.sendMessage(ChatColor.BLUE + "고객님의 잔액이 부족합니다.");
			}
		}
		default: {
			player.sendMessage(ChatColor.BLUE + "잘못된 명령어 접근입니다.");
		}
		}

		return true;
	}
}
