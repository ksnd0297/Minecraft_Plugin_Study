package me.ksnd0297.Doctor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor; // hover
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Heal implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("doctor")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("you've benn healed*");

				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("doctor.use")) {
				player.sendMessage(ChatColor.RED + "You cannot use this command!");
				return true;
			}
			if (args.length == 0) {
				// /doctor
				TextComponent message = new TextComponent("Would you like to be healed?");
				message.setColor(ChatColor.GOLD);
				message.setBold(true);
				message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
				message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
						new ComponentBuilder("Click here to be healed!").color(ChatColor.GRAY).italic(true).create()));
				player.spigot().sendMessage(message);
				return true;
			}
			// /doctor healme
			if (args[0].equalsIgnoreCase("healme")) {
				player.setHealth(20.0);
				// Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal " +
				// player.getName());
				player.sendMessage(ChatColor.GREEN + "You've benn healed!");
				return true;
			}
			player.sendMessage(ChatColor.RED + "Usage: /doctor");
		}
		return false;
	}

}
