package me.ksnd0297.Launch;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {

	}

	public boolean onCommnad(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("launch")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("console goes flaying");
				return true;
			}
			Player player = (Player) sender;
			if (args.length == 0) {
				// launch
				player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zoooooooom!");
				player.setVelocity(player.getLocation().getDirection());
			}
		}
		return false;
	}

}
