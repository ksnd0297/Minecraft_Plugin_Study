package ksnd0297.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Connection conn = null;
		Player player = e.getPlayer();
		UUID uuid = player.getUniqueId();

		String sql = "INSERT INTO Test VALUES(?, ?)";
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "Economy.db";
			conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, uuid.toString());
			pstmt.setInt(2, 500);

			pstmt.executeUpdate();

		} catch (Exception error) {
			error.printStackTrace();
		}
	}

}
