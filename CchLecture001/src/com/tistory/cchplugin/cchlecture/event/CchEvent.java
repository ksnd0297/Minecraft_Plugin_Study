package com.tistory.cchplugin.cchlecture.event;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.tistory.cchplugin.cchlecture.Main;

public class CchEvent implements Listener {

	public static Main plugin;

	public HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();

	public static void setPlugin(Main MainPlugin) {
		plugin = MainPlugin;
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {

		UUID uuid = e.getPlayer().getUniqueId();

		if (map.containsKey(uuid)) {
			map.put(uuid, map.get(uuid) + 1);
		} else {
			map.put(uuid, 1);
		}

		int count = map.get(uuid);

		e.setJoinMessage(count + "번째 입장했습니다!");

	}

}
