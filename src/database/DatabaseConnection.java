package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public Connection databaseLink;
	
	public Connection getConnection() {
		String databaseName = "kinzcol";
		String databaseUser = "java";
		String databasePassword = "connecteroonie";
		String url = "jdbc:mysql://localhost/" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return databaseLink;
	}
}
