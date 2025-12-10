package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import objects.Account;
import objects.Database;
import javafx.event.ActionEvent;

public class LoginController {

	@FXML private Button cancelButton;
	@FXML private Button loginButton;
	@FXML private Label loginMessageLabel;
	@FXML private TextField usernameTextField;
	@FXML private PasswordField passwordPasswordField;
	//public Account account = new Account(0, null, null);
	private Account account;
	
	public void cancelButtonOnAction(ActionEvent event) throws IOException {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/views/main.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void loginButtonOnAction(ActionEvent event) {
		if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
			validateLogin();
		} else {
			loginMessageLabel.setText("Please enter username and password.");
		}
	}
	
	public void validateLogin() {
		DatabaseConnection connect = new DatabaseConnection();
		Connection connectDB = connect.getConnection();
		
		String verifyLogin = "SELECT count(1) FROM account WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
		
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			
			while(queryResult.next()) {
				if(queryResult.getInt(1) == 1) {
					Database db = new Database();
					if(account == null) {
						account = new Account(db.getUserID(usernameTextField.getText(), passwordPasswordField.getText()), usernameTextField.getText(), passwordPasswordField.getText());
					}
					//System.out.println("ACCOUNT USERNAME/ID: " + account.getUsername() + " " + account.getUserID());
					loginMessageLabel.setText("Welcome!");
					homeMenu(loginMessageLabel.getScene().getWindow());
				} else {
					loginMessageLabel.setText("Incorrect username/password. Please try again.");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void homeMenu(Window window) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
			Parent root = loader.load();
			
			HomeController controller = loader.getController();
			controller.setCurrentAccount(account);
			
			Stage stage = (Stage) window.getScene().getWindow();
		    stage.setScene(new Scene(root));
		    stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}
