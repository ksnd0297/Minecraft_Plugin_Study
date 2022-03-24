package ksnd0297.makeSignPlugin.event;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ksnd0297.makeSignPlugin.db.ApiUser;

public class ListenerJoinEvent implements Listener {
	ApiUser apiUser;
	HashMap<String, Integer> userMap;

	public ListenerJoinEvent(ApiUser apiUser, HashMap<String, Integer> userMap) {
		this.apiUser = apiUser;
		this.userMap = userMap;
	}

	@EventHandler
	public void joinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String uuid = player.getUniqueId().toString();
		if (!userMap.containsKey(uuid))
			apiUser.enterUser(uuid);
	}
}
