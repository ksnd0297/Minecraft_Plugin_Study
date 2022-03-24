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
	HashMap<String, MySign> signMap;

	public ListenerClickEvent(HashMap<String, MySign> map) {
		this.signMap = map;
	}

	@EventHandler
	public void clickEvent(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();

		if (action == Action.LEFT_CLICK_BLOCK) { // 구매
			Block block = event.getClickedBlock();
			if (block.getType() == Material.OAK_SIGN) {
				Sign sign = (Sign) block.getState();
				if (signMap.containsKey(sign.getLine(0))) {
					MySign mySign = signMap.get(sign.getLine(0));

					if (checkIdentify(mySign, sign)) {
						System.out.println("AAA");
					} else {
						System.out.println("BBB");
					}
				}
			}
		}
	}

	public boolean checkIdentify(MySign mySign, Sign sign) {
		if (mySign.x == sign.getX() && mySign.y == sign.getY() && mySign.z == sign.getZ()) {
			return true;
		}
		return false;
	}
}
