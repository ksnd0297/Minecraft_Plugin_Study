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
import org.bukkit.inventory.EquipmentSlot;

import ksnd0297.makeSignPlugin.main.MySign;

public class ListenerClickEvent implements Listener {
	HashMap<String, MySign> signMap;
	HashMap<String, Integer> userMap;

	public ListenerClickEvent(HashMap<String, MySign> signMap, HashMap<String, Integer> userMap) {
		this.signMap = signMap;
		this.userMap = userMap;
	}

	@EventHandler
	public void clickEvent(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		String uuid = player.getUniqueId().toString();
		Block block = event.getClickedBlock();

		if (block.getType() == Material.OAK_SIGN) {
			Sign sign = (Sign) block.getState();
			if (signMap.containsKey(sign.getLine(0)) && userMap.containsKey(uuid)) {
				MySign mySign = signMap.get(sign.getLine(0));
				if (checkIdentify(mySign, sign)) {
					int userMoney = userMap.get(uuid);
					int buyMoney = mySign.buy; // 구매가격
					int sellMoney = mySign.sell; // 판매가격격

					if (action == Action.LEFT_CLICK_BLOCK) // 구매
						userMap.put(uuid, userMoney - buyMoney);
					else if (event.getAction() == Action.RIGHT_CLICK_BLOCK // 판매
							&& event.getHand().equals(EquipmentSlot.HAND))
						userMap.put(uuid, userMoney + sellMoney);

					player.sendMessage("거래가 완료되었습니다.");
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
