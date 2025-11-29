package objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnection;
import javafx.collections.ObservableList;

public class Database {
	DatabaseConnection connect = new DatabaseConnection();
	Connection connectDB = connect.getConnection();
	
	public void getFullItemList(ObservableList<String> items) {
		//DatabaseConnection connect = new DatabaseConnection();
		//Connection connectDB = connect.getConnection();
		
		String getAll = "SELECT name FROM clothing UNION SELECT name FROM food UNION SELECT name FROM item ORDER BY name";
		
		try {
			Statement statement = connectDB.createStatement();
			ResultSet itemResult = statement.executeQuery(getAll);
			
			while(itemResult.next()) {
				items.add(itemResult.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getFood() {
		String getFood = "SELECT * FROM food";
		ResultSet resultFood = null;
		try {
			Statement statement = connectDB.createStatement();
			resultFood = statement.executeQuery(getFood);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultFood;
	}
}
