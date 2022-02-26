package ksnd0297.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CloneEconomyDB_Insert {
	Connection con = null;

	private Connection Connect() {
		try {
			Class.forName("org.sqlite.JDBC");

			String dbFile = "Economy.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
		} catch (Exception e) {
			System.out.println("Error1!");
			e.printStackTrace();
		}

		return con;

	}

	// Insert a new row into table

	public void Insert(String uuid, int Money, int Auth) {
		String sql = "INSERT INTO People VALUES(?,?,?)";
		try {
			Connection conn = this.Connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, uuid);
			pstmt.setInt(2, Money);
			pstmt.setInt(3, Auth);

			pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
