package ksnd0297.makeSignPlugin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ApiSign {
	Connection con = null;

	public ApiSign(Connection con) {
		this.con = con;
	}

	public boolean insertSign(String position, String item, int buy, int sell, String matchItem) {
		try {
			String SQL = "INSERT INTO sign VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(SQL); // SQL문을 DB에 보내기 위한 객체
			pstmt.setString(1, position);
			pstmt.setString(2, item);
			pstmt.setInt(3, buy);
			pstmt.setInt(4, sell);
			pstmt.setString(5, matchItem);
			pstmt.executeUpdate();
			return true;
		} catch (Exception error) {
			error.printStackTrace();
		}

		return false;
	}
}
