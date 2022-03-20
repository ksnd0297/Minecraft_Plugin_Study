package ksnd0297.makeSignPlugin.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MakeSpecialSign implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		if (args.length != 0)
			return false;

		if (player.isOp()) {
			try {
				ItemStack sign = new ItemStack(Material.OAK_SIGN);
				ItemMeta itemMeta = sign.getItemMeta();
				itemMeta.setDisplayName(ChatColor.BLUE + "<특수 목적 표지판>");
				List<String> loreList = new ArrayList<String>();
				loreList.add("<물건 명>");
				loreList.add("<구매액>");
				loreList.add("<판매액>");
				itemMeta.setLore(loreList);
				itemMeta.setCustomModelData(1151);

				sign.setItemMeta(itemMeta);
				player.getInventory().addItem(sign);

			} catch (Exception error) {
				error.printStackTrace();
			}
		}

		return true;
	}

}
