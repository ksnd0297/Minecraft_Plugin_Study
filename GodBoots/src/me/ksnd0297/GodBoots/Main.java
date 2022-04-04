package me.ksnd0297.GodBoots;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("godboots")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Sorry console you're  not allowed to fly.");
				return true;
			}
			Player player = (Player) sender;
			if (player.getInventory().firstEmpty() == -1) {
				// inventory is full
				Location loc = player.getLocation();
				World world = player.getWorld();

				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "The Minecraft Legends dropped a gift near you.");
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "The Minecraft Legends gave you a gift.");
			return true;
		}
		return false;
	}

	public ItemStack getItem() {
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = boots.getItemMeta();

		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of Leaping");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Boots made for the Minecraft Gods");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);

		boots.setItemMeta(meta);

		return boots;
	}
}
