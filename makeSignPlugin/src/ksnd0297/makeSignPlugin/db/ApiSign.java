package ksnd0297.makeSignPlugin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import ksnd0297.makeSignPlugin.main.MySign;

public class ApiSign {
	Connection con = null;

	public ApiSign(Connection con) {
		this.con = con;
	}

	public void insertSign(MySign sign) {
		try {
			String SQL = "INSERT INTO sign VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(SQL); // SQL문을 DB에 보내기 위한 객체
			pstmt.setInt(1, sign.x);
			pstmt.setInt(2, sign.y);
			pstmt.setInt(3, sign.z);
			pstmt.setString(4, sign.item);
			pstmt.setInt(5, sign.buy);
			pstmt.setInt(6, sign.sell);
			pstmt.setString(7, sign.matchItem);
			pstmt.executeUpdate();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public HashMap<String, MySign> selectSign() {
		HashMap<String, MySign> map = new HashMap<String, MySign>();
		try {
			String SQL = "SELECT * FROM sign";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int getX = rs.getInt(1);
				int getY = rs.getInt(2);
				int getZ = rs.getInt(3);
				String item = rs.getString(4);
				int buy = rs.getInt(5);
				int sell = rs.getInt(6);
				String matchItem = rs.getString(7);
				MySign mySign = new MySign(getX, getY, getZ, item, buy, sell, matchItem);
				map.put(item, mySign);
			}

			return map;
		} catch (Exception error) {
			error.printStackTrace();
		}
		return map;
	}
}
