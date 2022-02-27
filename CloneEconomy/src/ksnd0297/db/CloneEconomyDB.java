package ksnd0297.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloneEconomyDB {

	private Connection Connect() {
		Connection con = null;

		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "Economy.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return con;
	}

	public Boolean PlayerJoinInsert(String Uuid, int Money) {
		Connection con = this.Connect();
		String sql = "SELECT Money FROM Person WHERE Uuid=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Uuid);

			ResultSet row = pstmt.executeQuery();
			while (row.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		sql = "INSERT INTO Person VALUES(?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Uuid);
			pstmt.setInt(2, Money);
			pstmt.executeUpdate();
			return true;
		} catch (Exception error) {
			error.printStackTrace();
			return false;
		}
	}

}
