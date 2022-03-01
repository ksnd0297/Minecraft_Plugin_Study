package ksnd0297.event;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class WorldEdit implements Listener {
	private Location LeftClickBlock = null;
	private Location RightClickBlock = null;
	private Player player = null;

	@EventHandler
	public void setPosition(PlayerInteractEvent e) {
		this.player = e.getPlayer();

		if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
			Block block = e.getClickedBlock();
			setLeftClickBlock(block.getLocation());
		} else if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand().equals(EquipmentSlot.HAND)) {
			Block block = e.getClickedBlock();
			setRightClickBlock(block.getLocation());
		}
	}

	public Location getLeftClickBlock() {
		return this.LeftClickBlock;
	}

	public void setLeftClickBlock(Location leftClickBlock) {
		LeftClickBlock = leftClickBlock;
		player.sendMessage("좌클릭 지정");

	}

	public Location getRightClickBlock() {
		return this.RightClickBlock;
	}

	public void setRightClickBlock(Location rightClickBlock) {
		RightClickBlock = rightClickBlock;
		player.sendMessage("우클릭 지정");
	}
}
