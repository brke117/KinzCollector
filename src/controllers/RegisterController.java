package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import database.DatabaseConnection;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class RegisterController {

	@FXML Button cancelButton;
	@FXML Button registerButton;
	@FXML Label registrationMessageLabel;
	@FXML TextField usernameTextField;
	@FXML PasswordField passwordPasswordField;
	
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/views/Main.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void registerButtonOnAction(ActionEvent e) {
		if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
			registerUser();
		} else {
			registrationMessageLabel.setText("Please set a username and password.");
		}
	}
	
	public void registerUser() {
		DatabaseConnection connect = new DatabaseConnection();
		Connection connectDB = connect.getConnection();
		
		String username = usernameTextField.getText();
		String password = passwordPasswordField.getText();
		
		String insertFields = "INSERT INTO account(username, password) VALUES('";
		String insertValues = username + "','" + password + "')";
		String insertToRegister = insertFields + insertValues;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate(insertToRegister);
			
			registrationMessageLabel.setTextFill(Color.GREEN);
			registrationMessageLabel.setText("Account creation successful. Switching to login...");
			
			PauseTransition delay = new PauseTransition(Duration.seconds(2));
			delay.setOnFinished(event -> loginForm(registrationMessageLabel.getScene().getWindow()));
			delay.play();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			registrationMessageLabel.setText("Username/password taken. Please choose another.");
		}
	}
	
	public void loginForm(Window window) {
		try {
			Stage stage;
			stage = (Stage) window.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}