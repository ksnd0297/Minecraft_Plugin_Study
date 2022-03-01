package ksnd0297.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ksnd0297.event.WorldEdit;
import net.md_5.bungee.api.ChatColor;

public class WorldEditFill implements CommandExecutor {
	private Location startBlock = null;
	private Location endBlock = null;

	public WorldEditFill(WorldEdit worldEdit) {
		startBlock = worldEdit.getLeftClickBlock();
		endBlock = worldEdit.getRightClickBlock();
	}

	@Override
	// / 채우기 블록
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();

		if (player.isOp()) {
			if (startBlock == null) {
				player.sendMessage(ChatColor.BLUE + "시작점을 입력해 주세요( 좌클릭 )");
				return true;
			} else if (endBlock == null) {
				player.sendMessage(ChatColor.BLUE + "끝점을 입력해 주세요( 우클릭 )");
				return true;
			}

			int startX = startBlock.getBlockX();
			int startY = startBlock.getBlockY();
			int startZ = startBlock.getBlockZ();

			int endX = endBlock.getBlockX();
			int endY = endBlock.getBlockY();
			int endZ = endBlock.getBlockZ();

			for (int x = Math.min(startX, endX); x <= Math.max(startX, endX); x++) {
				for (int y = Math.min(startY, endY); y <= Math.max(startY, endY); y++) {
					for (int z = Math.min(startZ, endZ); z <= Math.max(startZ, endZ); z++) {
						Location loc = new Location(world, x, y, z);
						loc.getBlock().setType(Material.STONE);
					}
				}
			}

		}
		return true;
	}
}
