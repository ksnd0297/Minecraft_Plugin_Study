package ksnd0297.makeSignPlugin.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connection() {
		try {
			Class.forName("org.sqlite.JDBC");

			String dbFile = "economy.db";
			Connection con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			return con;
		} catch (Exception error) {
			error.printStackTrace();
		}
		return null;
	}
}
