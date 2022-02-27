package ksnd0297.event;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ksnd0297.db.CloneEconomyDB;

public class PlayerJoin implements Listener {
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		UUID Uuid = player.getUniqueId();

		CloneEconomyDB db = new CloneEconomyDB();

		if (db.PlayerJoin(Uuid.toString(), 500)) {
			player.sendMessage(ChatColor.BLUE + player.getName() + "님 환영합니다!");
		} else {
			player.sendMessage(ChatColor.BLUE + player.getName() + "님 입장하였습니다");
		}
	}

}
