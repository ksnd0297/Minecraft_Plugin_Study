package ksnd0297.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloneEconomyDB {
	Connection con = null;

	private Connection Connect() {

		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "Economy.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
		} catch (Exception error) {
			error.printStackTrace();
		}
		return con;
	}

	public Boolean PlayerJoin(String Uuid, int Money) {
		Connection con = this.Connect();
		String sql = "SELECT * FROM Person WHERE Uuid=?";
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

	public int getMoney(String Uuid) {
		Connection con = this.Connect();
		String sql = "SELECT Money FROM Person WHERE Uuid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Uuid);

			ResultSet row = pstmt.executeQuery();
			while (row.next()) {
				return row.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean UpdateMoney(String Uuid, int Money) {
		Connection con = this.Connect();
		String sql = "UPDATE Person set Money = ? where Uuid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Money);
			pstmt.setString(2, Uuid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
