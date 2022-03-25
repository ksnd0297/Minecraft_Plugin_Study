package ksnd0297.makeSignPlugin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class ApiUser {
	Connection con = null;

	public ApiUser(Connection con) {
		this.con = con;
	}

	public void enterUser(String uuid) {
		try {
			String SQL = "INSERT INTO user VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, uuid);
			pstmt.setInt(2, 500);
			pstmt.executeUpdate();
			System.out.println("aaa");
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public HashMap<String, Integer> selectUser() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try {
			String SQL = "SELECT * FROM user";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String uuid = rs.getString(1);
				int money = rs.getInt(2);
				map.put(uuid, money);
			}
			return map;
		} catch (Exception error) {
			error.printStackTrace();
		}
		return map;
	}

}
