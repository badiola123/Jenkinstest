package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConfig {

	private static final String serverName = "localhost";
	private static final String dataBaseName = "mvc_exercise";
	private static final String url = "jdbc:mysql://";
	private static final String username = "root";
	private static final String password = "admin@eskola";

	public static final String connectionString = url + serverName + "/" + dataBaseName;
	
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionString,
					username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Connection Driver Error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could Not Connect to DB ");
		}
		return connection;
	}

	public static void disconnect(Connection connection, Statement statement) {
		try {
			if (statement != null) {
				statement.clearWarnings();
				statement.close();
			}

			if (connection != null) {
				connection.clearWarnings();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error disconnecting");
		}
	}
}
