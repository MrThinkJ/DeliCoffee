package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Connect {
	private static String DB_URL = "jdbc:mysql://localhost:3306/DeliCoffee";
	private static String USER_NAME = "root";
	private static String PASSWORD = "28122003";
	private static Connection conn = null;

	private static Connection getConnection(String dbURL, String userName, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

	public static Connection openConnect() {
		try {
			if (Objects.isNull(conn) || conn.isClosed()) {
				return getConnection(DB_URL, USER_NAME, PASSWORD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
