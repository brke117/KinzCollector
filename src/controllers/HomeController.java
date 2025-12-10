package controllers;

import java.io.IOException;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import objects.Account;

public class HomeController {

	@FXML Button checklistsMenuButton;
	@FXML Button viewItemMenuButton;
	@FXML Button settingsMenuButton;
	@FXML Button calculationsMenuButton;
	private Account account;
	
	public void checklistsMenuButtonOnAction(ActionEvent event) {
		//UniversalMethods unimet = new UniversalMethods();
		//unimet.switchScene(event, "checklists.fxml");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/checklists.fxml"));
			Parent root = loader.load();
			
			ChecklistsController controller = loader.getController();
			controller.setCurrentAccount(account);
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setScene(new Scene(root));
		    stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewItemMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "viewItem.fxml");
	}
	
	public void settingsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "settings.fxml");
	}
	
	public void calculationsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "calculations.fxml");
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}
