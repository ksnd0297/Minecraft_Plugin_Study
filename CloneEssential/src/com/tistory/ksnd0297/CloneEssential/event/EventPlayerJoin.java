package com.tistory.ksnd0297.CloneEssential.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class EventPlayerJoin implements Listener {
	@EventHandler
	public void join(PlayerJoinEvent e) {
		e.setJoinMessage(ChatColor.RED + "[서버에 입장하셨습니다.]");
	}
}
