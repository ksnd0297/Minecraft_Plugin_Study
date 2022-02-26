import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqliteTest {

	public static void main(String[] args) {
		Connection con = null;

		try {
			// SQLite JDBC 체크
			Class.forName("org.sqlite.JDBC");

			// SQLite 데이터베이스 파일에 연결
			String dbFile = "Test.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

			// SQL 수행
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("SELECT ID, Name FROM User");
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("Name");

				System.out.println(id + "         " + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
