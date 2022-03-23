package ksnd0297.makeSignPlugin.event;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import ksnd0297.makeSignPlugin.main.MySign;

public class ListenerClickEvent implements Listener {
	HashMap<String, MySign> map;

	public ListenerClickEvent(HashMap<String, MySign> map) {
		map = this.map;
	}

	@EventHandler
	public void ClickEvent(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		Block block = event.getClickedBlock();

		if (block.getType() == Material.OAK_SIGN) {
			Sign sign = (Sign) block.getState();
			String auth = sign.getLine(3);
			if (auth.equals("ㅤㅤㅤㅤㅤ")) {
				if (action == Action.LEFT_CLICK_BLOCK) {

					MySign mySign = map.get(sign.getLine(0));
					System.out.println(mySign.sell);
				}
			}
		}
	}
}
