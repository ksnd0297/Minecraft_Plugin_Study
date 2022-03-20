package ksnd0297.makeSignPlugin.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class MakeSign implements Listener {
	@EventHandler
	public void parserSign(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action clickAction = event.getAction();
		Block block = event.getClickedBlock();
		Material material = block.getType();

		// TODO : 특별한 표지판인지 체크할 필요가 있음

		if (clickAction == Action.LEFT_CLICK_BLOCK) {
			if (material.equals(Material.OAK_SIGN)) {
				Sign sign = (Sign) block.getState();
				String[] lines = sign.getLines();
			}
		} else if (clickAction == Action.RIGHT_CLICK_BLOCK && event.getHand().equals(EquipmentSlot.HAND)) {
			player.sendMessage("우클릭");
		}
	}
}
