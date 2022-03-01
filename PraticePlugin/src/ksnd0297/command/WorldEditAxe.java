package ksnd0297.command;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class WorldEditAxe implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;

		if (player.isOp()) {

			ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
			ItemMeta axeMeta = axe.getItemMeta();

			axeMeta.setDisplayName(ChatColor.GOLD + "월드에딧");
			axeMeta.setCustomModelData(1000);
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("월드에딧 전용 도끼");
			lore.add("[좌 | 우] 클릭 영역 지정");
			axeMeta.setLore(lore);

			axe.setItemMeta(axeMeta);
			player.getInventory().addItem(axe);
		}
		return true;
	}

}
