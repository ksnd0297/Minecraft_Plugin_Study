package ksnd0297.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ksnd0297.event.WorldEdit;
import net.md_5.bungee.api.ChatColor;

public class WorldEditFill implements CommandExecutor {
	private WorldEdit worldEdit;

	public WorldEditFill(WorldEdit worldEdit) {
		this.worldEdit = worldEdit;
	}

	@Override
	// / 채우기 블록
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Location startBlock = worldEdit.getLeftClickBlock();
		Location endBlock = worldEdit.getRightClickBlock();
		Player player = (Player) sender;
		World world = player.getWorld();

		if (player.isOp()) {

			@SuppressWarnings("deprecation")
			ItemStack worldEditAxe = player.getItemInHand();
			if (worldEditAxe != new ItemStack(Material.AIR, 0)) {
				System.out.println(worldEditAxe.toString());
				if (worldEditAxe.getItemMeta().getCustomModelData() == 1000) {

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
								loc.getBlock().setType(Material.getMaterial(args[0]));
							}
						}
					}
				} else {
					player.sendMessage(ChatColor.BLUE + "/도끼 명령어를 실행해 주세요.");
				}
			}

		}
		return true;
	}
}
