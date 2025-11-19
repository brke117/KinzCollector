package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.IOException;
import javafx.event.*;

public class MainController {

	@FXML Button signInButton;
	@FXML Button signUpButton;
	
	public void signInButtonOnAction(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;
		
		stage = (Stage) signInButton.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void signUpButtonOnAction(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;
		
		stage = (Stage) signUpButton.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("register.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}