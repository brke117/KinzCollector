package controllers;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import objects.Account;

public class ComingSoonController {

	@FXML Button backButton;
	@FXML ImageView nittyImageView;
	@FXML AnchorPane rootAnchorPane;
	private Account account;
	
	public void backButtonOnAction(ActionEvent e) {
		UniversalMethods unimet = new UniversalMethods();
		HomeController controller = new HomeController();
		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Home.fxml", controller);
	}
	
	@FXML
	public void initialize() {
		nittyImageView.setPreserveRatio(true);
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}
